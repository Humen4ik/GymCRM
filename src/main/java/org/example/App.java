package org.example;

import org.example.conf.BaseConfig;
import org.example.dto.TraineeDto;
import org.example.dto.TrainerDto;
import org.example.dto.TrainingDto;
import org.example.facade.TraineeFacade;
import org.example.facade.TrainerFacade;
import org.example.facade.TrainingFacade;
import org.example.mapper.TraineeMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;


public class App
{
    public static void main(String[] args) {
        // Створюємо Spring ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);

//        // Отримуємо сховища з бінів (Map)
//        Map<String, Trainee> trainees = context.getBean("traineeRepo", Map.class);
//        Map<String, Trainer> trainers = context.getBean("trainerRepo", Map.class);
//        Map<String, Training> trainings = context.getBean("trainingRepo", Map.class);
//
//        // Виводимо завантажених Trainee
//        System.out.println("\nLoaded Trainees:");
//        trainees.values().forEach(System.out::println);
//
//        // Виводимо завантажених Trainer
//        System.out.println("\nLoaded Trainers:");
//        trainers.values().forEach(System.out::println);
//
//        // Виводимо завантажених Training
//        System.out.println("\nLoaded Trainings:");
//        trainings.values().forEach(System.out::println);

//        gymFacade.getAllTrainers().forEach(System.out::println);
//        gymFacade.getAllTrainings().forEach(System.out::println);
//        gymFacade.getAllTrainees().stream().forEach(System.out::println);

        TraineeFacade traineeFacade = context.getBean(TraineeFacade.class);
        TraineeDto dto = new TraineeDto("John", "Doe", "address", LocalDate.of(2003, 9, 17), true, 110L);
//        traineeFacade.saveTrainee(dto);
        TraineeMapper traineeMapper = TraineeMapper.INSTANCE;
        System.out.println(traineeMapper.dtoToTrainee(dto));
//
//        System.out.println(traineeFacade.updateTrainee(dto));
//        traineeFacade.deleteTraineeByUsername("John.Doe");
//        System.out.println(traineeFacade.getTraineeByUsername("John.Doe"));
//        traineeFacade.getAllTrainee().forEach(System.out::println);

//        TrainerFacade trainerFacade = context.getBean(TrainerFacade.class);
//        TrainerDto trainerDto = new TrainerDto("David", "Wilson", true, "CCoolCoach");
//        System.out.println(trainerFacade.updateTrainer(trainerDto));
//        trainerFacade.getAllTrainers().stream().forEach(System.out::println);

        TrainingFacade trainingFacade = context.getBean(TrainingFacade.class);
//        List<TrainingDto> trainings = trainingFacade.getAllTraining();
//        System.out.println(trainings);
//        TrainingDto dto = trainingFacade.getTrainingByTrainingName("Evening Yoga Flow");
//        System.out.println(dto);

        // Закриваємо контекст
        context.close();
    }
}
