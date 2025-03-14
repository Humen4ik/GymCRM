package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TrainingDao;
import org.example.model.Training;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingDao trainingDao;

    public void save(Training training) {
        trainingDao.save(training);
    }

    public Training getTraining(String trainingName) {
        return trainingDao.findByTrainingName(trainingName).orElseThrow(() -> new RuntimeException("Training " + trainingName + " not found"));
    }

    public List<Training> getAllTrainings() {
        return trainingDao.getAllTrainings();
    }
}
