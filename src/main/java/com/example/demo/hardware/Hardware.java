package com.example.demo.hardware;

import com.pi4j.io.gpio.*;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@Component
public class Hardware {
    private RestTemplate restTemplate;

    public Hardware(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getTemperature(){
        DHTxx dht11 = new DHT11(RaspiPin.GPIO_04);
        String temperature = null;
        try {
            dht11.init();
            int i = (int)(dht11.getData().getTemperature());
            temperature = Integer.toString(i);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return temperature;
    }

    public String getHumidity(){
        DHTxx dht11 = new DHT11(RaspiPin.GPIO_04);
        String humidity = null;
        try {
            dht11.init();
            int i = (int)(dht11.getData().getHumidity());
            humidity = Integer.toString(i);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return humidity;
    }

    public String getHumidity2(){
        Runtime r = Runtime.getRuntime();
        System.out.println(1);
        Process p = null;
        String line = "";
        while(line=="") {
            try {
                System.out.println(2);
                p = r.exec("python serial1.py");
                System.out.println(3);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                System.out.println(4);
                p.waitFor();
                System.out.println(5);
                while (true) {
                    System.out.println(6);
                    if (!br.ready()) break;
                    line = br.readLine();
                }
            } catch (IOException e) {
                System.out.println(7);
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                System.out.println(8);
                throw new RuntimeException(e);
            }
        }
        System.out.println(9);
        System.out.println(line);
        return line;
    }

}
