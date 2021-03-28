package com.example.demo.controller;

import com.example.demo.entity.GrowBox;
import com.example.demo.service.GrowBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/growbox")
public class GrowBoxController {

    @Autowired
    GrowBoxService growBoxService;

    @PostMapping("/uploadconfig")
    public void uploadGrowBoxConfig(@RequestBody GrowBox growBox){
        growBoxService.updateGrowBox(growBox);
    }
}
