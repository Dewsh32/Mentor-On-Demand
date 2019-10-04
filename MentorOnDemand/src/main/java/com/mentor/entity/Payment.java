package com.mentor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment extends AuditModel {
	
	
private static final long serialVersionUid=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="txn_type",nullable=false)
	private String txnType;
	
	@Column(name="amount",nullable=false)
	private Integer amount;
	
	@Column(name="remarks",nullable=false)
	private String remarks;
	
	@Column(name="mentor_Id",nullable=false)
	private Integer mentorId;
	
	
	@Column(name="user_Id")
	private Integer userId;
	
	
	@Column(name="mentor_name",nullable=false)
	private String mentorName;
	
	@Column(name="trainingId",nullable=false)
	private Integer trainingId;
	
	@Column(name="skill_name",nullable=false)
	private String skillName;
	
	@Column(name="total_amount_mentor",nullable=false)
	private Integer totalAmountToMentor;
	
	@Column(name="payment_type",nullable=false)
	private String paymentType;
	
	


	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getTotalAmountToMentor() {
		return totalAmountToMentor;
	}

	public void setTotalAmountToMentor(Integer totalAmountToMentor) {
		this.totalAmountToMentor = totalAmountToMentor;
	}
	
	public void setmentorAmount(Integer amount)
	{	
		this.totalAmountToMentor=this.totalAmountToMentor+amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setamtrem(String remarks, Integer amount)
	{
		if(remarks.equals(this.remarks))
		{
			return;
		}
		else
		{
			this.remarks=remarks;
			this.totalAmountToMentor=this.totalAmountToMentor+amount;
		}
	}
	
	public Integer getMentorId() {
		return mentorId;
	}

	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	

}
