package com.example.demo.entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class GrowBox {

    private List<Integer> temperature;
    private List<Integer> humidity;
    private List<Integer> co2;

    public List<Integer> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Integer> temperature) {
        this.temperature = temperature;
    }

    public List<Integer> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Integer> humidity) {
        this.humidity = humidity;
    }

    public List<Integer> getCo2() {
        return co2;
    }

    public void setCo2(List<Integer> co2) {
        this.co2 = co2;
    }
}
