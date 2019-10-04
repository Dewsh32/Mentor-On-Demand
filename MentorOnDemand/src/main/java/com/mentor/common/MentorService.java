package com.mentor.common;

import java.util.List;

import com.mentor.entity.Mentor;
import com.mentor.entity.User;

public interface MentorService {

    Mentor create(Mentor mentor);

    Mentor delete(int id);

    List<Mentor> findAll();

    Mentor findById(int id);

    Mentor update(Mentor mentor);
    
    Mentor findMentor(String userName,String password);
}
