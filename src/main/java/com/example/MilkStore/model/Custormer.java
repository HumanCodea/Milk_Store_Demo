package com.example.MilkStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Custormer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String roles;
    
    public Custormer() {
    }

    public Custormer(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
