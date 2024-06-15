package com.example.MilkStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MilkStore.model.MyMilk;

@Repository
public interface MyMilkRepository extends JpaRepository<MyMilk, Integer>{
    
    @Query("Select m From MyMilk m Where m.nameMilk Like %?1%")
    public List<MyMilk> findMyMilkByName(String nameMilk);
    
    @Query("Select count(*) From MyMilk")
    public int findCountCartMilk();

}
