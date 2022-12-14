package com.example.khairislimani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KhairiSlimaniApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhairiSlimaniApplication.class, args);
    }

}
