package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PersonalDataService {

    public String generatePassword() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        SecureRandom rand = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int symbolIndex = rand.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(symbolIndex));
        }
        return password.toString();
    }

    public String generateUsername(User user) {
        return user.getFirstName().concat(".").concat(user.getLastName());
    }

}
