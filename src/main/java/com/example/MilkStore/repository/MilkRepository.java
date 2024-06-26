package com.example.MilkStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MilkStore.model.Milk;

@Repository
public interface MilkRepository extends JpaRepository<Milk, Integer> {
    @Query("Select m From Milk m Where m.nameMilk Like %?1%")
    public List<Milk> findByNameMilk(String nameMilk);

    @Query("Select count(*) From Milk")
    public int findCountMilk();

    @Query("Select m From Milk m ORDER BY m.pricesMilk ASC")
    public List<Milk> sortMilkASC();

    @Query("Select m From Milk m ORDER BY m.pricesMilk DESC")
    public List<Milk> sortMilkDESC();
 
}
