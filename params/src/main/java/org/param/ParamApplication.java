package org.param;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParamApplication {

    public static void main(String[] args) {
        SpringApplication s = new SpringApplication();
        s.setAddCommandLineProperties(false);
        s.run(ParamApplication.class, args);
    }
}
