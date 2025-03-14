package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TraineeDao;
import org.example.dto.TraineeDto;
import org.example.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraineeService {

    private final TraineeDao traineeDao;
    private PersonalDataService personalDataService;

    public Trainee save(Trainee trainee){
        System.out.println("save trainee: service");
        String username = personalDataService.generateUsername(trainee, getAllTrainees());
        String password = personalDataService.generatePassword();
        trainee.setUsername(username);
        trainee.setPassword(password);
        return traineeDao.save(trainee).orElseThrow(() -> new RuntimeException("save trainee failed"));
    }

    public Trainee getTrainee(String username) {
        return traineeDao.findByUsername(username)
                .orElseThrow(()->new RuntimeException("Trainee not found"));
    }

    public List<Trainee> getAllTrainees() {
        return traineeDao.findAll();
    }

    public boolean deleteTrainee(String username) {
        return traineeDao.delete(username);
    }

    @Autowired
    private void setPersonalDataService(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    public Trainee update(Trainee trainee) {
        System.out.println("update trainee: service");
        return traineeDao.update(trainee).orElseThrow(() -> new RuntimeException("update trainee failed"));
    }

    public Long countTrainee(Trainee trainee) {
        return traineeDao.countUniqueSerialNumber(trainee.getUsername());
    }

    public boolean existsByUsername(String newUsername) {
        return traineeDao.existByUsername(newUsername);
    }
}
