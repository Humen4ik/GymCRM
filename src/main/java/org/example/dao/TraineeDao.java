package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.model.Trainee;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class TraineeDao {

    private final Map<String, Trainee> trainees;

    public Optional<Trainee> save(Trainee trainee) {
        System.out.println("save trainee: dao");
        trainees.put(trainee.getUsername(), trainee);
        return Optional.ofNullable(trainees.get(trainee.getUsername()));
    }

    public Optional<Trainee> findByUsername(String username) {
        return Optional.ofNullable(trainees.get(username));
    }

    public boolean delete(String username) {
        if (!trainees.containsKey(username)) {
            return false;
        }
        trainees.remove(username);
        return true;
    }

    public Optional<Trainee> update(Trainee trainee) {
        if (!trainees.containsKey(trainee.getUsername())) {
            throw new IllegalArgumentException("Trainee with username " + trainee.getUsername() + " not found.");
        } else {
            trainees.put(trainee.getUsername(), trainee);
            return Optional.ofNullable(trainees.get(trainee.getUsername()));
        }
    }

    public List<Trainee> findAll() {
        return new ArrayList<>(trainees.values());
    }

    public Long countUniqueSerialNumber(String username) {
        return trainees.values().stream().filter(trainee -> trainee.getUsername().contains(username)).count();
    }

    public boolean existByUsername(String newUsername) {
        return trainees.containsKey(newUsername);
    }
}
