package org.example.conf;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.example.model.enums.TrainingType;
import org.example.service.PersonalDataService;
import org.example.service.TraineeService;
import org.example.service.TrainerService;
import org.example.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class DataInitializer {

    private TraineeService traineeService;
    private TrainerService trainerService;
    private TrainingService trainingService;

    @Value("${trainee.data.file.path}")
    private String traineeFilePath;

    @Value("${trainer.data.file.path}")
    private String trainerFilePath;

    @Value("${training.data.file.path}")
    private String trainingFilePath;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Autowired
    public void setTraineeService(TraineeService traineeService) {
        System.out.println("setTraineeService");
        this.traineeService = traineeService;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        System.out.println("setTrainerService");
        this.trainerService = trainerService;
    }

    @Autowired
    public void setTrainingService(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostConstruct
    private void init() {
        loadTrainees();
        loadTrainers();
        loadTrainings();
    }

    private void loadTrainees() {
        System.out.println("Loading trainees...");
        try (InputStream in = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(traineeFilePath))) {
            JsonNode rootNode = objectMapper.readTree(in);
            for (JsonNode node : rootNode.get("trainees")) {
                Trainee trainee = objectMapper.treeToValue(node, Trainee.class);
                traineeService.save(trainee);
            }
            System.out.println(traineeService.getAllTrainees());
        } catch (IOException e) {
            throw new RuntimeException("Error loading trainees", e);
        }
    }

    private void loadTrainers() {
        System.out.println("Loading trainers...");
        try (InputStream in = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(trainerFilePath))) {
            JsonNode rootNode = objectMapper.readTree(in);
            for (JsonNode node : rootNode.get("trainers")) {
                Trainer trainer = objectMapper.treeToValue(node, Trainer.class);
                trainerService.save(trainer);
            }
            System.out.println(trainerService.getAllTrainers());
        } catch (IOException e) {
            throw new RuntimeException("Error loading trainers", e);
        }
    }

    private void loadTrainings() {
        System.out.println("Loading trainings...");
        try (InputStream in = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(trainingFilePath))) {
            JsonNode rootNode = objectMapper.readTree(in);
            for (JsonNode node : rootNode.get("trainings")) {

                String trainerUsername = node.get("trainerUsername").asText();
                Trainer trainer = trainerService.findByUsername(trainerUsername);

                String traineeUsername = node.get("traineeUsername").asText();
                Trainee trainee = traineeService.getTrainee(traineeUsername);

                LocalDateTime dateTime = LocalDateTime.parse(node.get("dateTime").asText());
                Long duration = node.get("durationMinutes").asLong();
                TrainingType type = TrainingType.valueOf(node.get("type").asText());
                String trainingName = node.get("trainingName").asText();

                Training training = new Training(trainee, trainer, trainingName, type, dateTime, duration);
                trainingService.save(training);

            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading trainings", e);
        }
    }
}
