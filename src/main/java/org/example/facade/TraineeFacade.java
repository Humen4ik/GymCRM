package org.example.facade;

import lombok.RequiredArgsConstructor;
import org.example.dto.TraineeDto;
import org.example.mapper.TraineeMapper;
import org.example.service.TraineeService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class TraineeFacade {

    private final TraineeService service;
//    private final GymMapper gymMapper = GymMapper.INSTANCE;
    private final TraineeMapper traineeMapper = TraineeMapper.INSTANCE;

    public List<TraineeDto> getAllTrainee() {
        return service.getAllTrainees().stream().map(traineeMapper::traineeToDto).collect(Collectors.toList());
    }

    public TraineeDto getTraineeByUsername(String username) {
        return traineeMapper.traineeToDto(service.getTrainee(username));
    }

    public boolean deleteTraineeByUsername(String username) {
        return service.deleteTrainee(username);
    }

    public TraineeDto saveTrainee(TraineeDto dto) {
        return traineeMapper.traineeToDto(service.save(traineeMapper.dtoToTrainee(dto)));
    }

    public TraineeDto updateTrainee(TraineeDto dto) {
        return traineeMapper.traineeToDto(service.update(traineeMapper.dtoToTrainee(dto)));
    }

}
