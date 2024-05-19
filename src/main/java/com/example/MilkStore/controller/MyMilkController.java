package com.example.MilkStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MilkStore.model.MyMilk;
import com.example.MilkStore.service.MyMilkServices;

@Controller
@RequestMapping(path = "")
public class MyMilkController {

    @Autowired
    private MyMilkServices myMilkServices;
    
    @GetMapping("/my_milk")
    public String ListMyMilk(Model model, @Param("nameMilk") String nameMilk){
        List<MyMilk> list = myMilkServices.getAllMyMilk();
        if(nameMilk != null){
            list = myMilkServices.findMyMilkByName(nameMilk);
            model.addAttribute("nameMilk", nameMilk);
        }
        model.addAttribute("Milk", list);
        return "myMilk";
    }

    @GetMapping("/deleteMyList/{id}")
    public String DeleteMyMilk(@ModelAttribute("id") int id){
        myMilkServices.DeleteMyMilk(id);
        return "redirect:/my_milk";
    }

}
