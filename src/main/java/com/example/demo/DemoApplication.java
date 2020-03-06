package com.example.demo;

import com.example.demo.init.InitializApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        InitializApplication.initializApplication();
        SpringApplication.run(DemoApplication.class, args);
    }

}
