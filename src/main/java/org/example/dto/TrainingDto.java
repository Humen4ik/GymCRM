package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.enums.TrainingType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainingDto {
    private String trainingName;
    private TrainerDto trainerDto;
    private TraineeDto traineeDto;
    private String dateTime;
    private Long durationMinutes;
    private TrainingType type;
}
