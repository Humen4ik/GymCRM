package org.example.facade;

import lombok.RequiredArgsConstructor;
import org.example.dao.TrainingDao;
import org.example.dto.TrainingDto;
import org.example.mapper.TrainingMapper;
import org.example.model.Training;
import org.example.service.TrainingService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrainingFacade {

    private final TrainingService trainingService;
    private final TrainingMapper trainingMapper = TrainingMapper.INSTANCE;

    public List<TrainingDto> getAllTraining(){
        return trainingService.getAllTrainings().stream().map(trainingMapper::trainingToDto).collect(Collectors.toList());
    }

    public TrainingDto getTrainingByTrainingName(String trainingName) {
        return trainingMapper.trainingToDto(trainingService.getTraining(trainingName));
    }

}
