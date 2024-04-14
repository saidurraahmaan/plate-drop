package com.s4r.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.s4r")
public class PlateDropMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlateDropMainApplication.class, args);
    }
}
