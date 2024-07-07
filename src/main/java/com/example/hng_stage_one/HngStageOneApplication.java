package com.example.hng_stage_one;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controller, service, model") // Replace ApiEndpoint with your actual package name
public class HngStageOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(HngStageOneApplication.class, args);
    }

}
