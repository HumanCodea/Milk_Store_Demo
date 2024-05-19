package com.example.MilkStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyMilk {
    @Id
    private int id;
    @Column(name = "name_milk")
    private String nameMilk;
    private String typeMilk;
    private String dateMilk;
    private int acountMilk;
    private int pricesMilk;
    private String photoMilk;
    
    public MyMilk() {
    }

    public MyMilk(int id, String nameMilk, String typeMilk, String dateMilk, int acountMilk, int pricesMilk,
            String photoMilk) {
        this.id = id;
        this.nameMilk = nameMilk;
        this.typeMilk = typeMilk;
        this.dateMilk = dateMilk;
        this.acountMilk = acountMilk;
        this.pricesMilk = pricesMilk;
        this.photoMilk = photoMilk;
    }

}
