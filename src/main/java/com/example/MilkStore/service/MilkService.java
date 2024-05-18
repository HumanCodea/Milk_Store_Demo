package com.example.MilkStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MilkStore.model.Milk;
import com.example.MilkStore.repository.MilkRepository;

@Service
public class MilkService{
    
    @Autowired
    private MilkRepository milkRepository;

    public List<Milk> getAllMilk(){
        return milkRepository.findAll();
    }

    public List<Milk> findByNameMilk(String nameMilk){
        return  milkRepository.findByNameMilk(nameMilk);
    }

    public void DeleteMilk(int id){
        milkRepository.deleteById(id);
    }

    public Milk findMilkById(int id){
        return milkRepository.findById(id).get();
    }

    public void saveMilk(Milk milk){
        milkRepository.save(milk);
    }
}
