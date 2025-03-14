package org.example.mapper;

import org.example.dto.TrainingDto;
import org.example.model.Training;
import org.example.model.enums.TrainingType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(uses = {TraineeMapper.class, TrainerMapper.class})
public interface TrainingMapper {

    TrainingMapper INSTANCE = Mappers.getMapper(TrainingMapper.class);

    @Mapping(source = "trainer", target = "trainerDto")
    @Mapping(source = "trainee", target = "traineeDto")
    @Mapping(source = "trainingDate", target ="dateTime", qualifiedByName = "localDateTimeToString")
    @Mapping(source = "duration", target = "durationMinutes")
    @Mapping(source ="trainingType", target = "type", conditionQualifiedByName = "mapTrainingType")
    TrainingDto trainingToDto(Training training);

    @Mapping(source = "trainerDto", target = "trainer")
    @Mapping(source = "traineeDto", target = "trainee")
    @Mapping(source = "dateTime", target ="trainingDate", qualifiedByName = "stringToLocalDateTime")
    @Mapping(source = "durationMinutes", target = "duration")
    @Mapping(source ="type", target = "trainingType", conditionQualifiedByName = "stringToTrainingType")
    Training trainingDtoToTraining(TrainingDto trainingDto);

    @Named("localDateTimeToString")
    static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Named("trainingTypeToString")
    static String mapTrainingType(TrainingType trainingType) {
        return trainingType.name();
    }

    @Named("stringToLocalDateTime")
    static LocalDateTime stringToLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Named("stringToTrainingType")
    static TrainingType stringToTrainingType(String trainingType) {
        return TrainingType.valueOf(trainingType);
    }

}
