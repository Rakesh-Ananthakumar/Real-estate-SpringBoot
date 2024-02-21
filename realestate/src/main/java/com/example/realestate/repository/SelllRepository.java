package com.example.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realestate.model.SellModel;

@Repository
public interface SelllRepository extends JpaRepository<SellModel,Integer>
{
    
}
