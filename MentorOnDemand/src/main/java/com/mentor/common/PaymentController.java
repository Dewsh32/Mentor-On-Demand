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

import com.mentor.entity.Payment;
import com.mentor.entity.Training;

@EnableJpaRepositories("com.mentor.*")
@ComponentScan(basePackages = { "com.mentor.*" })
@EntityScan("com.mentor.*")   

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/payment"})
public class PaymentController {

	
	 @Autowired
	    private PaymentService paymentService;
	 @Autowired
	 	private TrainingService trainingService;

	 @PostMapping
	    public Payment create(@RequestBody Payment payment){
	        return paymentService.create(payment);
	    }

	    @GetMapping(path = {"/{id}"})
	    public Payment findOne(@PathVariable("id") int id){
	        return paymentService.findById(id);
	    }
	    
	    
	    @GetMapping(path = "/{amount}/{remark}/{id}")
	    public Payment SetAmount(@PathVariable("amount") float amount,@PathVariable("remark") String remark,@PathVariable("id") Integer id){
	    	
	    	int amt=(int) amount;
	    	Payment payment=paymentService.findById(id);
	    	//payment.setmentorAmount(amount);
	    	//payment.setRemarks(remark);
	        payment.setamtrem(remark, amt);
	    	return paymentService.create(payment);
	    }
	    
	    
	    @GetMapping(path = {"/withdraw/{id}/{amount}"})
	    public Payment withdraw(@PathVariable("id") int id,@PathVariable("amount") int amount){
	    	Payment payment=paymentService.findById(id);
	    	payment.setmentorAmount(-amount);
	        return paymentService.create(payment);
	    }
	    
	    
	    

	    @PutMapping(path = {"/{id}"})
	    public Payment update(@PathVariable("id") int id, @RequestBody Payment payment){
	        payment.setId(id);
	        return paymentService.update(payment);
	    }

	    @DeleteMapping(path ={"/{id}"})
	    public Payment delete(@PathVariable("id") int id) {
	        return paymentService.delete(id);
	    }
	    
	    @GetMapping(path = {"/findbyuser/{userid}"})
	    public List<Payment> findByUser(@PathVariable("userid") int userid){
	        return paymentService.findByUser(userid);
	    }
	    
	    @GetMapping(path = {"/findbymentor/{mentorid}"})
	    public List<Payment> findByMentor(@PathVariable("mentorid") int mentorid){
	        return paymentService.findByMentor(mentorid);
	    }
	    
	    
	    @GetMapping(path = {"/payfees/{id}/{amount}"})
	    public Payment payfees(@PathVariable("id") int id,@PathVariable("amount") int amount){
	    	Payment payment=paymentService.findById(id);
	    	Training training=trainingService.findById(payment.getTrainingId());
	    	payment.setAmount(amount);
	    	training.setAmountRecieved(amount);
	    	trainingService.create(training);
	        return paymentService.create(payment);
	    }
	    


	    @GetMapping
	    public List<Payment> findAll(){
	        return paymentService.findAll();
	    }

	    
	
	@RequestMapping({"/print"})
	public String greetHello()
	{
		return "hello";
		
	}
}
