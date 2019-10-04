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

import com.mentor.entity.Mentor;
import com.mentor.entity.User;

@EnableJpaRepositories("com.mentor.*")
@ComponentScan(basePackages = { "com.mentor.*" })
@EntityScan("com.mentor.*")   

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/mentor"})
public class MentorController {

	
	 @Autowired
	    private MentorService mentorService;

	 @PostMapping
	    public Mentor create(@RequestBody Mentor mentor){
	        return mentorService.create(mentor);
	    }

	    @GetMapping(path = {"/{id}"})
	    public Mentor findOne(@PathVariable("id") int id){
	        return mentorService.findById(id);
	    }

	    @PutMapping(path = {"/{id}"})
	    public Mentor update(@PathVariable("id") int id, @RequestBody Mentor mentor){
	        mentor.setId(id);
	        return mentorService.update(mentor);
	    }

	    @DeleteMapping(path ={"/{id}"})
	    public Mentor delete(@PathVariable("id") int id) {
	        return mentorService.delete(id);
	    }
	    
	    @GetMapping(path = {"/{userName}/{password}"})
	    public Mentor findMentor(@PathVariable("userName") String userName, 
	    		@PathVariable(value = "password") String password){
	    	System.out.println(userName+password+mentorService.findMentor(userName, password));
	        return mentorService.findMentor(userName, password);
	    }

	    

	    @GetMapping
	    public List<Mentor> findAll(){
	        return mentorService.findAll();
	    }

	    
	
	@RequestMapping({"/print"})
	public String greetHello()
	{
		return "hello";
		
	}
}
