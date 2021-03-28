package com.example.demo.service;

import com.example.demo.entity.GrowBox;

public class GrowBoxServiceImpl implements GrowBoxService{
    private GrowBox growBox = null;

    @Override
    public GrowBox createGrowBox(GrowBox growBox) {
        this.growBox = growBox;
        return this.growBox;
    }

    @Override
    public void updateGrowBox(GrowBox growBox) {
        this.growBox = growBox;
        System.out.println(growBox.toString());
    }

    @Override
    public GrowBox getGrowBox() {
        return growBox;
    }
}
