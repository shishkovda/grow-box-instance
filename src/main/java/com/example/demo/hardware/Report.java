package com.example.demo.hardware;

import com.example.demo.entity.GrowBox;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Component
public class Report {

    private RestTemplate restTemplate;

    public Report(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Scheduled(fixedRate = 5000)
    public void sendReport(){
        GrowBox growBox = new GrowBox();
        Hardware hardware = new Hardware(new RestTemplateBuilder());
        String temperature = hardware.getTemperature();
        String humidity = hardware.getHumidity();
        String humidity2 = hardware.getHumidity2();
        createPost(temperature, humidity, humidity2);
        System.out.println(temperature);
        System.out.println(humidity);
        System.out.println(humidity2);
    }

    public Object createPost(String temperature, String humidity, String humidity2) {

        String url = "http://178.154.208.211:8080/api/history";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();
        map.put("growBoxId", 1);
        map.put("date", ZonedDateTime.now(ZoneId.of("UTC+4")));
        map.put("temperature", temperature);
        map.put("humidity", humidity);
        map.put("co2", humidity2);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Object> response = this.restTemplate.postForEntity(url, entity, Object.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
