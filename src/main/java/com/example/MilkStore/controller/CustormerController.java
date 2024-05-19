package com.example.MilkStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MilkStore.model.Custormer;
import com.example.MilkStore.service.CustormerService;

@Controller
@RequestMapping(path = "")
public class CustormerController {

    @Autowired
    private CustormerService custormerService;
    
    @GetMapping("/login")
    public String LoginUser(){
        return "loginUser";
    }

    @GetMapping("/register")
    public String RegisterUser(){
        return "registerUser";
    }

    @PostMapping("/saveUser")
    public String SaveCustormer(@ModelAttribute Custormer custormer){
        custormerService.SaveUser(custormer);
        return "redirect:/register?successfully";
    }

    @GetMapping("/logout")
    public String LogoutPage(){
        return "loginUser";
    }

    @GetMapping("/infor")
    public String InforPage(){
        return "inforUser";
    }
}
