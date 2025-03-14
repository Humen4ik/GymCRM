package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TraineeDto {
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate dateOfBirth;
    private Boolean isActive;
    private Long userId;
}
