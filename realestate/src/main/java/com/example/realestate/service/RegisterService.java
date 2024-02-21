package com.example.realestate.service;

import org.springframework.stereotype.Service;

import com.example.realestate.model.RegisterModel;
import com.example.realestate.repository.RegisterRepo;
import java.util.List;
import java.util.Optional;


@Service
public class RegisterService {
    public RegisterRepo registerRepository;

    public RegisterService(RegisterRepo registerRepository) {
        this.registerRepository = registerRepository;
    }

    public boolean saveDetails(RegisterModel register) {
        try {
            registerRepository.save(register);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<RegisterModel> getDetails() {
        return registerRepository.findAll();
    }

    public boolean updatePassword(String email, RegisterModel register) {
        if (getDetailsbyId(email) == null) {
            System.out.println("\n Email not Found \n");
            return false;
        }
        try {
            registerRepository.save(register);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean deleteDetails(String email)
    {
        if(this.getDetailsbyId(email)==null)
        {
            return false;
        }
        registerRepository.deleteById(email);
        return true;
    }

    public RegisterModel getDetailsbyId(String email)
    {
        Optional<RegisterModel> obj = registerRepository.findById(email);
        return obj.orElse(null);
    }
}
