package org.example.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
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
@PropertySource("classpath:application.properties")
public class BaseConfig {

    @Bean
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
