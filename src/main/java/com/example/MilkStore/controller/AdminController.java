package com.example.MilkStore.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.MilkStore.model.Milk;
import com.example.MilkStore.model.MilkDTO;
import com.example.MilkStore.model.MyMilk;
import com.example.MilkStore.service.MilkService;
import com.example.MilkStore.service.MyMilkServices;

@Controller
@RequestMapping(path = "")
public class AdminController {
    
    @Autowired
    private MilkService milkService;

    @Autowired
    private MyMilkServices myMilkServices;

    @GetMapping("/homeAdmin")
    public String HomeAdmin(){
        return "homeAdmin";
    }

    @GetMapping("/available_milk")
    public String ManageMilk(Model model, @Param("nameMilk") String nameMilk){
        List<Milk> list = milkService.getAllMilk();
        if(nameMilk != null){
            list = milkService.findByNameMilk(nameMilk);
            model.addAttribute("nameMilk", nameMilk);
        }
        model.addAttribute("Milk", list);
        return "ManageMilk";
    }

    @GetMapping("deleteList/{id}")
    public String DeleteMilk(@ModelAttribute("id") int id){
        milkService.DeleteMilk(id);
        return "redirect:/available_milk";
    }

    @GetMapping("/editList/{id}")
    public String EditMilk(@ModelAttribute("id") int id, Model model){
        Milk milk = milkService.findMilkById(id);
        model.addAttribute("milk", milk);
        return "editMilk";
    }

    @PostMapping("/save")
    public String SaveMilk(@ModelAttribute Milk milk){
        milkService.saveMilk(milk);
        return "redirect:/available_milk";
    }

    @GetMapping("/milk_register")
    public String RegisterMilk(Model model){
        MilkDTO milkDTO = new MilkDTO();
        model.addAttribute("milkDto", milkDTO);
        return "registerMilk";
    }

    @PostMapping("/milk_register")
    public String SaveRegisterMilk(@ModelAttribute MilkDTO milkDTO){

        MultipartFile image = milkDTO.getPhotoMilk();
        String storageFileName = image.getOriginalFilename();

        try{
            String uploadDir = "static/picture/";
            Path uploadPath = Paths.get(uploadDir);

            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }

            try(InputStream inputStream = image.getInputStream()){
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                    StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e){
            System.out.println("ExceptionL:" + e.getMessage());
        }

        Milk milk = new Milk();
        milk.setNameMilk(milkDTO.getNameMilk());
        milk.setTypeMilk(milkDTO.getTypeMilk());
        milk.setDateMilk(milkDTO.getDateMilk());
        milk.setAcountMilk(milkDTO.getAcountMilk());
        milk.setPricesMilk(milkDTO.getPricesMilk());
        milk.setPhotoMilk(storageFileName);

        milkService.saveMilk(milk);
        return "redirect:/available_milk";
    }

    @GetMapping("/mylist/{id}")
    public String addToMyMilk(@ModelAttribute("id") int id){
        Milk milk = milkService.findMilkById(id);
        MyMilk myMilk = new MyMilk(milk.getId(), milk.getNameMilk(), milk.getTypeMilk(), milk.getDateMilk(), milk.getAcountMilk(), milk.getPricesMilk(), milk.getPhotoMilk());
        myMilkServices.SaveMyMilk(myMilk);
        return "redirect:/my_milk";
    }

}
