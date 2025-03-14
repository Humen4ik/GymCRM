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
        generatePersonalInformation(trainer);
        return trainerDao.save(trainer).orElseThrow(() -> new RuntimeException("Current trainer can not be saved"));
    }

    public Trainer findByUsername(String username) {
        return trainerDao.findByUsername(username).orElseThrow(() -> new RuntimeException("Trainer with username " + username + " Not Found"));
    }

    public Trainer update(Trainer trainer) {
        generatePersonalInformation(trainer);
        return trainerDao.update(trainer);
    }

    public List<Trainer> getAllTrainers() {
        return trainerDao.getAllTrainers();
    }

    @Autowired
    public void setPersonalDataService(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    private void generatePersonalInformation(Trainer trainer) {
        String username = personalDataService.generateUsername(trainer, getAllTrainers());
        String password = trainer.getPassword();
        trainer.setUsername(username);
        trainer.setPassword(password);
    }

    public boolean existsByUsername(String newUsername) {
        return trainerDao.existByUsername(newUsername);
    }
}