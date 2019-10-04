package com.mentor.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.entity.Payment;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repositoryp;

    @Override
    public Payment create(Payment payment) {
        return repositoryp.save(payment);
    }

    @Override
    public Payment delete(int id) {
        Payment payment = findById(id);
        if(payment != null){
            repositoryp.delete(payment);
        }
        return payment;
    }

    @Override
    public List<Payment> findAll() {
        return repositoryp.findAll();
    }

    @Override
    public Payment findById(int id) {
        return repositoryp.findOne(id);
    }

    @Override
    public Payment update(Payment payment) {
        return repositoryp.save(payment);
    }

	@Override
	public List<Payment> findByUser(int userid) {
		// TODO Auto-generated method stub
		return repositoryp.findByUser(userid);
	}

	@Override
	public List<Payment> findByMentor(int mentorid) {
		// TODO Auto-generated method stub
		return repositoryp.findByMentor(mentorid);
	}
}
