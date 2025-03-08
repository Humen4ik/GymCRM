package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Trainer extends User {
    private String specialization;
    private Long userId;

    public Trainer(String firstName, String lastName, Boolean isActive, String specialization, Long userId) {
        super(firstName, lastName, isActive);
        this.specialization = specialization;
        this.userId = userId;
    }
}
