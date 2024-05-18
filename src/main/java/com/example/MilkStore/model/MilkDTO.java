package com.example.MilkStore.model;

import org.springframework.web.multipart.MultipartFile;

public class MilkDTO {

    private int id;
    private String nameMilk;
    private String typeMilk;
    private String dateMilk;
    private int acountMilk;
    private int pricesMilk;
    private MultipartFile photoMilk;

    public MilkDTO() {
    }

    public MilkDTO(int id, String nameMilk, String typeMilk, String dateMilk, int acountMilk, int pricesMilk,
            MultipartFile photoMilk) {
        this.id = id;
        this.nameMilk = nameMilk;
        this.typeMilk = typeMilk;
        this.dateMilk = dateMilk;
        this.acountMilk = acountMilk;
        this.pricesMilk = pricesMilk;
        this.photoMilk = photoMilk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMilk() {
        return nameMilk;
    }

    public void setNameMilk(String nameMilk) {
        this.nameMilk = nameMilk;
    }

    public String getTypeMilk() {
        return typeMilk;
    }

    public void setTypeMilk(String typeMilk) {
        this.typeMilk = typeMilk;
    }

    public String getDateMilk() {
        return dateMilk;
    }

    public void setDateMilk(String dateMilk) {
        this.dateMilk = dateMilk;
    }

    public int getAcountMilk() {
        return acountMilk;
    }

    public void setAcountMilk(int acountMilk) {
        this.acountMilk = acountMilk;
    }

    public int getPricesMilk() {
        return pricesMilk;
    }

    public void setPricesMilk(int pricesMilk) {
        this.pricesMilk = pricesMilk;
    }

    public MultipartFile getPhotoMilk() {
        return photoMilk;
    }

    public void setPhotoMilk(MultipartFile photoMilk) {
        this.photoMilk = photoMilk;
    }

    
    
}
