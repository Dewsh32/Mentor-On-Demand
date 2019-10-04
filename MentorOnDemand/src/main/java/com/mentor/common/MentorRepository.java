package com.mentor.common;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.mentor.entity.Mentor;
import com.mentor.entity.User;

import java.util.List;

public interface MentorRepository extends Repository<Mentor, Integer> {

    void delete(Mentor mentor);

    List<Mentor> findAll();

    Mentor findOne(int id);

    Mentor save(Mentor mentor);
    
    @Query("select mentor from Mentor mentor where mentor.userName=? and mentor.password=?")
    Mentor findUser(String userName,String password);
}
