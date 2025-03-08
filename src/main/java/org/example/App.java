package org.example;

import org.example.conf.BaseConfig;
import org.example.conf.Test;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;


public class App 
{
    public static void main(String[] args) {
        // Створюємо Spring ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);

        System.out.println("Spring context initialized");

        Test test = context.getBean(Test.class); // Перевірка отримання біну
        System.out.println("Test bean: " + test);

        context.close();
    }
}
