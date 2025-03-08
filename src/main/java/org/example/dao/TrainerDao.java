package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.model.Trainer;
import org.springframework.stereotype.Repository;

import java.util.Map;

@RequiredArgsConstructor
@Repository
public class TrainerDao {

    private final Map<String, Trainer> trainers;

    public void save(Trainer trainer) {
        trainers.put(trainer.getUsername(), trainer);
    }

}
