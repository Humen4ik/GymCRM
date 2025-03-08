package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TrainerDao;
import org.example.model.Trainer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final TrainerDao trainerDao;

    public void save(Trainer trainer) {
        trainerDao.save(trainer);
    }

}
