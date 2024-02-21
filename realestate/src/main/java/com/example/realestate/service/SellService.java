package com.example.realestate.service;

import org.springframework.stereotype.Service;

import com.example.realestate.model.SellModel;
import com.example.realestate.repository.SelllRepository;
import java.util.List;
import java.util.Optional;

@Service
public class SellService {
    private SelllRepository selllRepository;

    public SellService(SelllRepository selllRepository)
    {
        this.selllRepository=selllRepository;
    }

    public boolean savSellModel(SellModel sellModel)
    {
        try{

            selllRepository.save(sellModel);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<SellModel> getListModel(SellModel sellModel)
    {
        return selllRepository.findAll();
    }

    public SellModel getModelID(Integer id)
    {
        Optional<SellModel> obj = selllRepository.findById(id);
        return obj.orElse(null);
    }


    public boolean updateModel(Integer id,SellModel sellModel)
    {
        if(this.getModelID(id)==null)
        {
            return false;
        }
        try{
            selllRepository.save(sellModel);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delModel(Integer id)
    {
        try{
            selllRepository.deleteById(id);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
