package com.example.MilkStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MilkStore.model.Milk;
import com.example.MilkStore.model.MyMilk;
import com.example.MilkStore.service.MilkService;
import com.example.MilkStore.service.MyMilkServices;

@Controller
@RequestMapping(path = "")
public class MilkController {

    @Autowired
    private MilkService milkService;

    @Autowired
    private MyMilkServices myMilkServices;
    
    @GetMapping("/home")
    public String Home(){
        return "homeUser";
    }

    @GetMapping("/list_milk")
    public String ListMilkUser(Model model){
        List<Milk> list = milkService.getAllMilk();
        int count = milkService.findCountMilk();
        model.addAttribute("Milk", list);
        model.addAttribute("count", count);
        return "listMilkUser";
    }

    @GetMapping("/cart_milk")
    public String CartMilk(Model model){
        List<MyMilk> list = myMilkServices.getAllMyMilk();
        int count = myMilkServices.findCountCartMilk();
        model.addAttribute("Milk", list);
        model.addAttribute("count", count);
        return "cartMilk";
    }

    @GetMapping("/sortASC")
    public String SortMilkASC(Model model){
        List<Milk> list = milkService.sortMilkASC();
        int count = milkService.findCountMilk();
        model.addAttribute("Milk", list);
        model.addAttribute("count", count);
        return "listMilkUser";
    }

    @GetMapping("/sortDESC")
    public String SortMilkDESC(Model model){
        List<Milk> list = milkService.sortMilkDESC();
        int count = milkService.findCountMilk();
        model.addAttribute("Milk", list);
        model.addAttribute("count", count);
        return "listMilkUser";
    }

    @GetMapping("/search_milk")
    public String SearchMilk(@Param("nameMilk") String nameMilk, Model model){
        List<Milk> list = milkService.findByNameMilk(nameMilk);
        model.addAttribute("nameMilk", nameMilk);
        model.addAttribute("Milk", list);
        int count = list.size();
        model.addAttribute("count", count);
        return "searchMilk";
    }

    @GetMapping("/cart_milk/{id}")
    public String addToCartMilk(@ModelAttribute("id") int id){
        Milk milk = milkService.findMilkById(id);
        MyMilk myMilk = new MyMilk(milk.getId(), milk.getNameMilk(), milk.getTypeMilk(), milk.getDateMilk(), milk.getAcountMilk(), milk.getPricesMilk(), milk.getPhotoMilk());
        myMilkServices.SaveMyMilk(myMilk);
        return "redirect:/cart_milk";
    }

    @GetMapping("/deleteCartList/{id}")
    public String DeleteCartMilk(@ModelAttribute("id") int id){
        myMilkServices.DeleteMyMilk(id);
        return "redirect:/cart_milk";
    }
}
