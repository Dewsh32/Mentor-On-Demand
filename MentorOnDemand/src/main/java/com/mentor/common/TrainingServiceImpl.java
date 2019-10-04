package com.mentor.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.entity.Training;

import java.util.Date;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository repositoryt;

    @Override
    public Training create(Training training) {
        return repositoryt.save(training);
    }

    @Override
    public Training delete(int id) {
        Training training = findById(id);
        if(training != null){
            repositoryt.delete(training);
        }
        return training;
    }

    @Override
    public List<Training> findAll() {
        return repositoryt.findAll();
    }

    @Override
    public Training findById(int id) {
        return repositoryt.findOne(id);
    }

    @Override
    public Training update(Training training) {
        return repositoryt.save(training);
    }

	@Override
	public List<Training> findTrainingByMentorId(Integer mentorId) {
		return repositoryt.findTrainingByMentorId(mentorId);
	}

	@Override
	public List<Training> findTrainingByUserId(Integer userId) {
		return repositoryt.findTrainingByUserId(userId);
	}

	@Override
	public Training findByTrainingIdAndMentorId(Integer trainingId, Integer mentorId) {
		return repositoryt.findByTrainingIdAndMentorId(trainingId, mentorId);
	}

	@Override
	public Training findByTrainingIdAndUserId(Integer trainingId, Integer userId) {
		return repositoryt.findByTrainingIdAndUserId(trainingId, userId);
	}

	@Override
	public List<Training> findTrainingComplete(int userId) {
		return repositoryt.findTrainingComplete(userId);
	}

	@Override
	public List<Training> findTrainingByStartDateBetween(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return repositoryt.findTrainingByStartDateBetween(startDate, endDate);
	}


}
