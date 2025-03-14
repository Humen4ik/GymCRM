package org.example.facade;

import lombok.RequiredArgsConstructor;
import org.example.dto.TrainerDto;
import org.example.mapper.TrainerMapper;
import org.example.model.Trainer;
import org.example.service.TraineeService;
import org.example.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrainerFacade {

    private final TrainerService trainerService;
    private TrainerMapper trainerMapper = TrainerMapper.INSTANCE;

    public List<TrainerDto> getAllTrainers() {
        return trainerService.getAllTrainers().stream().map(trainerMapper::trainerToDto).collect(Collectors.toList());
    }

    public TrainerDto saveTrainer(TrainerDto trainerDto) {
        return trainerMapper.trainerToDto(trainerService.save(trainerMapper.dtoToTrainer(trainerDto)));
    }

    public TrainerDto updateTrainer(TrainerDto trainerDto) {
        return trainerMapper.trainerToDto(trainerService.update(trainerMapper.dtoToTrainer(trainerDto)));
    }
}
