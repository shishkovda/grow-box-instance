package com.example.demo.hardware;

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.util.Console;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
public class HardwareTest {

    Hardware hardware = new Hardware(new RestTemplateBuilder());

//    @Test
//    void test() {
//        hardware.dht11GetData();
//    }
//
//    @Test
//    void test2() throws InterruptedException, PlatformAlreadyAssignedException {
//        hardware.test2();
//    }
//
//    @Test
//    void test3() throws InterruptedException, PlatformAlreadyAssignedException {
//        hardware.test3();
//    }

    @Test
    public void test3() throws PlatformAlreadyAssignedException, InterruptedException {
        Report report = new Report(new RestTemplateBuilder());
        report.sendReport();
    }


}
