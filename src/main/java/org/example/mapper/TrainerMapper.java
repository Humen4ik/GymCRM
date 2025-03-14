package org.example.mapper;

import org.example.dto.TrainerDto;
import org.example.model.Trainer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainerMapper {

    TrainerMapper INSTANCE = Mappers.getMapper(TrainerMapper.class);

    Trainer dtoToTrainer(TrainerDto trainerDto);
    TrainerDto trainerToDto(Trainer trainer);

}
