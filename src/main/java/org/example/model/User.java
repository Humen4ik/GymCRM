package org.example.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Boolean isActive;

    protected User(String firstName, String lastName, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
    }
}
