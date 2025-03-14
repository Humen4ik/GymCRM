package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.example.model.Training;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TrainingDao {
    private final Map<String, Training> trainings;

    public void save(Training training) {
        trainings.put(training.getTrainingName(), training);
    }

    public Optional<Training> findByTrainingName(String name) {
        return Optional.ofNullable(trainings.get(name));
    }

    public List<Training> getAllTrainings() {
        return new ArrayList<>(trainings.values());
    }
}
