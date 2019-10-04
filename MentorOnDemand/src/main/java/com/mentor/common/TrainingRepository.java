package com.mentor.common;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.mentor.entity.Training;

import java.util.Date;
import java.util.List;

public interface TrainingRepository extends Repository<Training, Integer> {

    void delete(Training training);

    List<Training> findAll();

    Training findOne(int id);

    Training save(Training training);
    
    @Query("select training from Training training where training.mentorId=?")
    List<Training> findTrainingByMentorId(Integer mentorId);
    
    @Query("select training from Training training where training.userId=? and training.progress<100")
    List<Training> findTrainingByUserId(Integer userId);
    
    @Query("select training from Training training where training.id=? and training.mentorId=?")
    Training findByTrainingIdAndMentorId(Integer trainingId,Integer mentorId);
    
    @Query("select training from Training training where training.id=? and training.userId=?")
    Training findByTrainingIdAndUserId(Integer trainingId,Integer userId);
    
    @Query("select training from Training training where training.userId=? and training.progress=100")
    List<Training> findTrainingComplete(int userId);
    
    List<Training> findTrainingByStartDateBetween(Date startDate,Date endDate);

  
    
}
