package com.mentor.common;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.mentor.entity.Skill;

import java.util.List;

public interface SkillRepository extends Repository<Skill, Integer> {

    void delete(Skill skill);

    List<Skill> findAll();

    Skill findOne(int id);

    Skill save(Skill skill);
    
    @Query("select skill from Skill skill where skill.mentorId=?")
    List<Skill> findByMentorId(int mentorId);
}
