package com.example.MilkStore.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Milk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_milk")
    private String nameMilk;
    private String typeMilk;
    private String dateMilk;
    private int acountMilk;
    private int pricesMilk;
    private String photoMilk;
    
    public Milk() {
    }

    public Milk(String nameMilk, String typeMilk, String dateMilk, int acountMilk, int pricesMilk, String photoMilk) {
        this.nameMilk = nameMilk;
        this.typeMilk = typeMilk;
        this.dateMilk = dateMilk;
        this.acountMilk = acountMilk;
        this.pricesMilk = pricesMilk;
        this.photoMilk = photoMilk;
    }

}
