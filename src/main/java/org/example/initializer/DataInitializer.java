package org.example.initializer;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

//    private TraineeService traineeService;
//    private TrainerService trainerService;
//    private PersonalDataService personalDataService;

//    @Value("${trainee.data.file.path}")
//    private String traineeFilePath;
//
//    @Value("${trainer.data.file.path}")
//    private String trainerFilePath;

//    private final ObjectMapper objectMapper = new ObjectMapper();

//    @Autowired
//    public void setTraineeService(TraineeService traineeService) {
//        System.out.println("setTraineeService");
//        this.traineeService = traineeService;
//    }
//
//    @Autowired
//    public void setTrainerService(TrainerService trainerService) {
//        System.out.println("setTrainerService");
//        this.trainerService = trainerService;
//    }
//
//    @Autowired
//    public void setPersonalDataService(PersonalDataService personalDataService) {
//        System.out.println("setPersonalDataService");
//        this.personalDataService = personalDataService;
//    }

    public DataInitializer() {
        System.out.println("Constructor DataInitializer");
    }

    @PostConstruct
    private void init() {
        System.out.println("Initializing data...");
//        loadTrainees();
//        loadTrainers();
    }

//    private void loadTrainees() {
//        System.out.println("Loading trainees...");
//        try (InputStream in = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(traineeFilePath))) {
//            JsonNode rootNode = objectMapper.readTree(in);
//            for (JsonNode node : rootNode.get("trainees")) {
//                Trainee trainee = objectMapper.treeToValue(node, Trainee.class);
//                trainee.setUsername(personalDataService.generateUsername(trainee));
//                trainee.setPassword(personalDataService.generatePassword());
//                traineeService.save(trainee);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Error loading trainees", e);
//        }
//    }
//
//    private void loadTrainers() {
//        System.out.println("Loading trainers...");
//        try (InputStream in = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(trainerFilePath))) {
//            JsonNode rootNode = objectMapper.readTree(in);
//            for (JsonNode node : rootNode.get("trainers")) {
//                Trainer trainer = objectMapper.treeToValue(node, Trainer.class);
//                trainer.setUsername(personalDataService.generateUsername(trainer));
//                trainer.setPassword(personalDataService.generatePassword());
//                trainerService.save(trainer);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Error loading trainers", e);
//        }
//    }
}
