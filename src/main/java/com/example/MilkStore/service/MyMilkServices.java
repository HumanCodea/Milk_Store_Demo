package com.example.MilkStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MilkStore.model.MyMilk;
import com.example.MilkStore.repository.MyMilkRepository;

@Service
public class MyMilkServices {
    
    @Autowired
    private MyMilkRepository myMilkRepository;

    public List<MyMilk> getAllMyMilk(){
        return myMilkRepository.findAll();
    }

    public void DeleteMyMilk(int id){
        myMilkRepository.deleteById(id);
    }

    public void SaveMyMilk(MyMilk myMilk){
        myMilkRepository.save(myMilk);
    }

    public List<MyMilk> findMyMilkByName(String nameMilk){
        return myMilkRepository.findMyMilkByName(nameMilk);
    }
}
