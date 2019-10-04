package com.mentor.common;

import java.util.Date;
import java.util.List;

import com.mentor.entity.Training;

public interface TrainingService {

    Training create(Training training);

    Training delete(int id);

    List<Training> findAll();

    Training findById(int id);

    Training update(Training training);

    List<Training> findTrainingByMentorId(Integer mentorId);
    
    List<Training> findTrainingByUserId(Integer userId);
    
    Training findByTrainingIdAndMentorId(Integer trainingId,Integer mentorId);
    
    Training findByTrainingIdAndUserId(Integer trainingId,Integer userId);

	List<Training> findTrainingComplete(int userId);

	List<Training> findTrainingByStartDateBetween(Date startDate, Date endDate);
    
}
