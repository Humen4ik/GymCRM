package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TrainerDao;
import org.example.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final TrainerDao trainerDao;
    private PersonalDataService personalDataService;

    public Trainer save(Trainer trainer) {
        trainer.setUsername(personalDataService.generateUsername(trainer, getAllTrainers()));
        trainer.setPassword(personalDataService.generatePassword());
        return trainerDao.save(trainer).orElseThrow(() -> new RuntimeException("Current trainer can not be saved"));
    }

    public Trainer findByUsername(String username) {
        return trainerDao.findByUsername(username).orElseThrow(() -> new RuntimeException("Trainer with username " + username + " Not Found"));
    }

    public Trainer updateByUsername(Trainer newTrainer, String username) {
        Trainer oldTrainer = findByUsername(username);
        if (newTrainer.getFirstName() != null) {
            oldTrainer.setFirstName(newTrainer.getFirstName());
        }
        if (newTrainer.getLastName() != null) {
            oldTrainer.setLastName(newTrainer.getLastName());
        }
        if (newTrainer.getIsActive() != null)
            oldTrainer.setIsActive(newTrainer.getIsActive());
        if (newTrainer.getUserId() != null)
            oldTrainer.setUserId(newTrainer.getUserId());
        if (newTrainer.getSpecialization() != null)
            oldTrainer.setSpecialization(newTrainer.getSpecialization());

        return trainerDao.update(newTrainer);
    }

    public List<Trainer> getAllTrainers() {
        return trainerDao.getAllTrainers();
    }

    @Autowired
    public void setPersonalDataService(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    public boolean existsByUsername(String newUsername) {
        return trainerDao.existByUsername(newUsername);
    }
}