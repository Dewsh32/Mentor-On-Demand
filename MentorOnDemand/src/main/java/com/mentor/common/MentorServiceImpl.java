package com.mentor.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.entity.Mentor;
import com.mentor.entity.User;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository repositorym;

    @Override
    public Mentor create(Mentor mentor) {
        return repositorym.save(mentor);
    }

    @Override
    public Mentor delete(int id) {
        Mentor mentor = findById(id);
        if(mentor != null){
            repositorym.delete(mentor);
        }
        return mentor;
    }

    @Override
    public List<Mentor> findAll() {
        return repositorym.findAll();
    }

    @Override
    public Mentor findById(int id) {
        return repositorym.findOne(id);
    }

    @Override
    public Mentor update(Mentor mentor) {
        return repositorym.save(mentor);
    }
    
    @Override
	public Mentor findMentor(String userName, String password) {
		
		return repositorym.findUser(userName, password);
	}
}
