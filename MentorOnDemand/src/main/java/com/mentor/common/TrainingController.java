package com.mentor.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.entity.Training;
import com.mentor.entity.User;

@EnableJpaRepositories("com.mentor.*")
@ComponentScan(basePackages = { "com.mentor.*" })
@EntityScan("com.mentor.*")   

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/training"})
public class TrainingController {

	
	 @Autowired
	    private TrainingService trainingService;
	 @Autowired
	 private UserService userService;

	
	 
	 
	 @PostMapping
	    public Training create(@RequestBody Training training){
	        return trainingService.create(training);
	    }
	 
	 @GetMapping(path="/{userid}/{trainingId}")
	    public Training TrainEnroll(@PathVariable("userid") Integer userid,
	    		@PathVariable(value = "trainingId") Integer trainingId){
		 
		 		Training training=trainingService.findById(trainingId);
		 		User user=userService.findById(userid);
		 		training.getUsers().add(user);
		 		 
		 		return trainingService.create(training);
	    }
	 @GetMapping(path="/ChangeCommision/{commission}/{trainingId}")
	    public Training ChangeCommission(@PathVariable(value = "commission") Integer commission,
	    		@PathVariable(value = "trainingId") Integer trainingId){
		 
		 		Training training=trainingService.findById(trainingId);
		 		training.setCommissionPercent(commission);
		 		 
		 		return trainingService.create(training);
	    }
	 
	 	

	    @GetMapping(path = {"/{id}"})
	    public Training findOne(@PathVariable("id") int id){
	        return trainingService.findById(id);
	    }
	    
	    @GetMapping("/findTrainingByMentorId/{mentorId}")
	    public List < Training > findTrainingByMentorId(@PathVariable(value = "mentorId") int mentorId) {
	        return trainingService.findTrainingByMentorId(mentorId);
	    }

	    
	    @GetMapping("/findTrainingByUserId/{userId}")
	    public List < Training > findTrainingByUserId(@PathVariable(value = "userId") int userId) {
	        return trainingService.findTrainingByUserId(userId);
	    }
	    

	    @GetMapping("/findTrainingComplete/{userId}")
	    public List < Training > findTrainingComplete(@PathVariable(value = "userId") int userId) {
	        return trainingService.findTrainingComplete(userId);
	    }
	    
	    @GetMapping("/findByTrainingIdAndMentorId/{mentorId}/{trainingId}")
	    public Training findByTrainingIdAndMentorId(@PathVariable(value = "mentorId") Integer mentorId,
	            @PathVariable(value = "trainingId") Integer trainingId) {
	        return trainingService.findByTrainingIdAndMentorId(trainingId, mentorId);
	    }
	    
	    
	    @GetMapping("/findByTrainingIdAndUserId/{userId}/{trainingId}")
	    public Training  findByTrainingIdAndUserId(@PathVariable(value = "userId") Integer userId,
	            @PathVariable(value = "trainingId") Integer trainingId) {
	        return trainingService.findByTrainingIdAndUserId(trainingId, userId);
	    }
	    
	    
	    
	    @GetMapping("/findTrainingByStartDateBetween/{startDate}/{endDate}")
	    public List <Training>  findTrainingByStardDateBetween(@PathVariable(value = "startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
	            @PathVariable(value = "endDate")  @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
	    	
	   
	    	return trainingService.findTrainingByStartDateBetween(startDate, endDate);
	    } 
	    /*
	    @GetMapping("/findTrainingByStartDateBetween/{startDate}/{endDate}")
	    public List <Training>  findTrainingByStardDateBetween(@PathVariable(value = "startDate") String startDate,
	            @PathVariable(value = "endDate") String endDate) {
	   
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	    	Date dateStartDate1;
			try {
				dateStartDate1 = simpleDateFormat.parse(startDate);
			} catch (ParseException e) {
				dateStartDate1=new Date();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Date dateStartDate2;
			try {
				dateStartDate2 = simpleDateFormat.parse(endDate);
			} catch (ParseException e) {
				dateStartDate2=new Date();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(dateStartDate1);
	    	 
	        return trainingService.findTrainingByStartDateBetween(dateStartDate1, dateStartDate2);
	    
	    }*/

	    

	    @PutMapping(path = {"/{id}"})
	    public Training update(@PathVariable("id") int id, @RequestBody Training training){
	        training.setTrainingId(id);
	        return trainingService.update(training);
	    }

	    @DeleteMapping(path ={"/{id}"})
	    public Training delete(@PathVariable("id") int id) {
	        return trainingService.delete(id);
	    }
	    
	    

	    @GetMapping
	    public List<Training> findAll(){
	        return trainingService.findAll();
	    }

	    
	
	@RequestMapping({"/print"})
	public String greetHello()
	{
		return "hello";
		
	}
}
