package org.example.conf;

import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "org.example")
public class BaseConfig {

    public Map<String, Trainee> traineeRepo() {
        return new HashMap<>();
    }

    @Bean
    public Map<String, Trainer> trainerRepo() {
        return new HashMap<>();
    }

    @Bean
    public Map<String, Training> trainingRepo() {
        return new HashMap<>();
    }

}
