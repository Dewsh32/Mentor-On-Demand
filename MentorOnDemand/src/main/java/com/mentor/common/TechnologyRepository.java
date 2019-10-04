package com.mentor.common;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.mentor.entity.Technology;

import java.util.List;

public interface TechnologyRepository extends Repository<Technology, Integer> {

    void delete(Technology technology);

    List<Technology> findAll();

    Technology findOne(int id);

    Technology save(Technology technology);
}
