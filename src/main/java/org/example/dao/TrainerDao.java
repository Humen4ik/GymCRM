package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.model.Trainer;
import org.springframework.stereotype.Repository;

import java.util.*;

@RequiredArgsConstructor
@Repository
public class TrainerDao {

    private final Map<String, Trainer> trainers;

    public Optional<Trainer> save(Trainer trainer) {
        trainers.put(trainer.getUsername(), trainer);
        return Optional.ofNullable(trainers.get(trainer.getUsername()));
    }

    public Optional<Trainer> findByUsername(String username) {
        return Optional.ofNullable(trainers.get(username));
    }

    public Trainer update(Trainer trainer) {
        if (trainers.containsKey(trainer.getUsername())) {
            trainers.put(trainer.getUsername(), trainer);
            return trainers.get(trainer.getUsername());
        } else {
            throw new IllegalArgumentException("Trainer with username " + trainer.getUsername() + " not found.");
        }
    }

    public List<Trainer> getAllTrainers() {
        return new ArrayList<>(trainers.values());
    }

    public boolean existByUsername(String newUsername) {
        return trainers.containsKey(newUsername);
    }
}
