package com.example.realestate.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.realestate.model.SellModel;
import com.example.realestate.service.SellService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SellController {
    private SellService sellService;

    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @PostMapping("/sell")
    public ResponseEntity<SellModel> postMethodName(@RequestBody SellModel sellModel) {
        if (sellService.savSellModel(sellModel) == true) {
            return new ResponseEntity<>(sellModel, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(sellModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/sells")
    public ResponseEntity<List<SellModel>> getMethodSell(SellModel sellModel) {
        List<SellModel> p = sellService.getListModel(sellModel);
        if (p.size() == 0) {
            return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/sell/{id}")
    public ResponseEntity<SellModel> putMethodName(@PathVariable("id") Integer id, @RequestBody SellModel sellModel) {
        if (sellService.updateModel(id, sellModel) == true) 
        {
            return new ResponseEntity<>(sellModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(sellModel, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/sell/{id}")
    public ResponseEntity<SellModel> delMethod(@PathVariable("id") Integer id)
    {
        if(sellService.delModel(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
