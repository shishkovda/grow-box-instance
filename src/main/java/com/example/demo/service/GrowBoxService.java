package com.example.demo.service;

import com.example.demo.entity.GrowBox;
import org.springframework.stereotype.Service;

@Service
public interface GrowBoxService {
    GrowBox createGrowBox(GrowBox growBox);
    void updateGrowBox(GrowBox growBox);
    GrowBox getGrowBox();
}
