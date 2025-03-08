package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TraineeDao;
import org.example.model.Trainee;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraineeService {

    private final TraineeDao traineeDao;

    public void save(Trainee trainee){
        System.out.println("save trainee: service");
        traineeDao.save(trainee);
    }

}
