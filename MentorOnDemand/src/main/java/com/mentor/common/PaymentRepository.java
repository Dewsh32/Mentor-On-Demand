package com.mentor.common;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.mentor.entity.Payment;

import java.util.List;

public interface PaymentRepository extends Repository<Payment, Integer> {

    void delete(Payment payment);

    List<Payment> findAll();

    Payment findOne(int id);

    Payment save(Payment payment);
    
    @Query("select payment from Payment payment where payment.userId=?")
    List<Payment> findByUser(int userid);
    
    @Query("select payment from Payment payment where payment.mentorId=?")
	List<Payment> findByMentor(int mentorid);
}
