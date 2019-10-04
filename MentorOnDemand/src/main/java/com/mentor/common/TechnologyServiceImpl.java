package com.mentor.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.entity.Technology;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository repositoryt;

    @Override
    public Technology create(Technology technology) {
        return repositoryt.save(technology);
    }

    @Override
    public Technology delete(int id) {
        Technology technology = findById(id);
        if(technology != null){
            repositoryt.delete(technology);
        }
        return technology;
    }

    @Override
    public List<Technology> findAll() {
        return repositoryt.findAll();
    }

    @Override
    public Technology findById(int id) {
        return repositoryt.findOne(id);
    }

    @Override
    public Technology update(Technology technology) {
        return repositoryt.save(technology);
    }
}
