package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.model.Trainee;
import org.springframework.stereotype.Repository;

import java.util.Map;

@RequiredArgsConstructor
@Repository
public class TraineeDao {

    private final Map<String, Trainee> trainees;

    public void save(Trainee trainee) {
        System.out.println("save trainee: dao");
        trainees.put(trainee.getUsername(), trainee);
    }
}
