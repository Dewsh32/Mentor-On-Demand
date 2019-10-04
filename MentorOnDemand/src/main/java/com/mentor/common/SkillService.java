package com.mentor.common;

import java.util.List;

import com.mentor.entity.Skill;

public interface SkillService {

    Skill create(Skill skill);

    Skill delete(int id);

    List<Skill> findAll();

    Skill findById(int id);

    Skill update(Skill skill);

	List<Skill> findByMentorId(int mentorId);
}
