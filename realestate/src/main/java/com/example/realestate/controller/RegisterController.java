package com.example.realestate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.realestate.model.RegisterModel;
import com.example.realestate.service.RegisterService;
import java.util.List;

@RestController
public class RegisterController {
    public RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterModel> postMethodName(@RequestBody RegisterModel register) {
        if (registerService.saveDetails(register) == true) {
            return new ResponseEntity<>(register, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/registers")
    public ResponseEntity<List<RegisterModel>> getMethodName() {
        List<RegisterModel> list =  registerService.getDetails();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @PutMapping("/register/{email}")
    public ResponseEntity<RegisterModel> putMethodName(@PathVariable("email") String email, @RequestBody RegisterModel register) {
        if (registerService.updatePassword(email, register) == true) {
            return new ResponseEntity<>(register, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/register/{email}")
    public ResponseEntity<RegisterModel> delete(@PathVariable("email") String mail)
    {
        if(registerService.deleteDetails(mail)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
