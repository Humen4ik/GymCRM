package org.example.model;

import org.example.model.enums.TrainingType;

import java.time.LocalDate;

public class Training {
    private Long traineeId;
    private Long trainerId;
    private String trainingName;
    private TrainingType trainingType;
    private LocalDate trainingDate;
    private Long duration;

}
