package com.metro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = "com.metro")
public class MetroManagementWebAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MetroManagementWebAppApplication.class, args);
    }

}
