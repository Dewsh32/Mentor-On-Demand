package com.mentor.common;

import java.util.List;

import com.mentor.entity.Technology;

public interface TechnologyService {

    Technology create(Technology technology);

    Technology delete(int id);

    List<Technology> findAll();

    Technology findById(int id);

    Technology update(Technology technology);
}
