package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TraineeDao;
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

    public Trainee update(Trainee newTrainee, String username) {
        System.out.println("update trainee: service");

        Trainee oldTrainee = getTrainee(username);

        if (newTrainee.getFirstName() != null) {
            oldTrainee.setFirstName(newTrainee.getFirstName());
        }
        if (newTrainee.getLastName() != null) {
            oldTrainee.setLastName(newTrainee.getLastName());
        }
        if (newTrainee.getAddress() != null) {
            oldTrainee.setAddress(newTrainee.getAddress());
        }
        if (newTrainee.getDateOfBirth() != null) {
            oldTrainee.setDateOfBirth(newTrainee.getDateOfBirth());
        }
        if (newTrainee.getIsActive() != null)
            oldTrainee.setIsActive(newTrainee.getIsActive());
        if (newTrainee.getUserId() != null)
            oldTrainee.setUserId(newTrainee.getUserId());

        return traineeDao.update(oldTrainee)
                .orElseThrow(() -> new RuntimeException("update trainee failed"));
    }


    public Long countTrainee(Trainee trainee) {
        return traineeDao.countUniqueSerialNumber(trainee.getUsername());
    }

    public boolean existsByUsername(String newUsername) {
        return traineeDao.existByUsername(newUsername);
    }

    public void mapOldTraineeToNewTrainee(Trainee oldTrainee, Trainee newTrainee) {

    }
}
