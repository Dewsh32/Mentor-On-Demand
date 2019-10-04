package com.mentor.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.entity.Skill;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository repositorys;

    @Override
    public Skill create(Skill skill) {
        return repositorys.save(skill);
    }

    @Override
    public Skill delete(int id) {
        Skill skill = findById(id);
        if(skill != null){
            repositorys.delete(skill);
        }
        return skill;
    }

    @Override
    public List<Skill> findAll() {
        return repositorys.findAll();
    }

    @Override
    public Skill findById(int id) {
        return repositorys.findOne(id);
    }

    @Override
    public Skill update(Skill skill) {
        return repositorys.save(skill);
    }

	@Override
	public List<Skill> findByMentorId(int mentorId) {
		// TODO Auto-generated method stub
		return repositorys.findByMentorId(mentorId);
	}
}
