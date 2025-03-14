package org.example.mapper;

import org.example.dto.TraineeDto;
import org.example.model.Trainee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TraineeMapper {

    TraineeMapper INSTANCE = Mappers.getMapper(TraineeMapper.class);

    TraineeDto traineeToDto(Trainee trainee);
    Trainee dtoToTrainee(TraineeDto dto);

}
