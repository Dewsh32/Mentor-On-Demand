package com.mentor.common;

import java.util.List;

import com.mentor.entity.Payment;

public interface PaymentService {

    Payment create(Payment payment);

    Payment delete(int id);

    List<Payment> findAll();

    Payment findById(int id);

    Payment update(Payment payment);

	List<Payment> findByUser(int userid);

	List<Payment> findByMentor(int mentorid);
}
