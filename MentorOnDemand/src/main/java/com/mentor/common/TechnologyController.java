package com.mentor.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.entity.Technology;



@EnableJpaRepositories("com.mentor.*")
@ComponentScan(basePackages = { "com.mentor.*" })
@EntityScan("com.mentor.*")   

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/technology"})
public class TechnologyController {

	
	 @Autowired
	    private TechnologyService technologyService;

	 @PostMapping
	    public Technology create(@RequestBody Technology technology){
	        return technologyService.create(technology);
	    }

	    @GetMapping(path = {"/{id}"})
	    public Technology findOne(@PathVariable("id") int id){
	        return technologyService.findById(id);
	    }

	    @PutMapping(path = {"/{id}"})
	    public Technology update(@PathVariable("id") int id, @RequestBody Technology technology){
	        technology.setId(id);
	        return technologyService.update(technology);
	    }

	    @DeleteMapping(path ={"/{id}"})
	    public Technology delete(@PathVariable("id") int id) {
	        return technologyService.delete(id);
	    }
	    
	    

	    @GetMapping
	    public List<Technology> findAll(){
	        return technologyService.findAll();
	    }

	    
	
	@RequestMapping({"/print"})
	public String greetHello()
	{
		return "hello";
		
	}
}
