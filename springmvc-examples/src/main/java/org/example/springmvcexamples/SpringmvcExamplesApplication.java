package org.example.springmvcexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcExamplesApplication {

    public static void main(String[] args) {
        System.out.println("SpringBoot Start…");
        try {
            SpringApplication.run(SpringmvcExamplesApplication.class, args);
        }catch(Exception e) {
            e.printStackTrace();
        }
        SpringApplication.run(SpringmvcExamplesApplication.class, args);
    }

}
