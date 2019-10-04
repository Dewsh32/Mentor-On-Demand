package com.mentor.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Training extends AuditModel {
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer trainingId;
	
	@Column(name="status")
	private String status;
	
	
	@Column(name="progress")
	private Integer progress=0;
	
	
	@Column(name="fees")
	private Integer fees=0;
	
	@Column(name="commission_percentage")
	private Integer commissionPercent=0;
	
	
	@Column(name="rating")
	private Integer rating=0;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="start_date")
	private Date startDate;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="end_date")
	private Date endDate;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name="start_time")
	private String startTime;
	
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name="end_time")
	private String endTime;
	
	
	@Column(name="amount_recieved")
	private Integer amountRecieved=0;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="mentor_id")
	private Integer mentorId;
	
	
	
	@Column(name="skill_id")
	private Integer skillId;
	
	
	@Column(name="razorpay_payment_id")
	private String razorpayPaymentId;


	@Column(name="amtToMentor")
	private Integer amtToMentor=0;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mentor_id",insertable=false,updatable=false)
	private Mentor mentors;
	
	
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "training_user", joinColumns = { 
			@JoinColumn(name = "training_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id", 
					nullable = false, updatable = false) })
	private List<User> users;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "training_skill", joinColumns = { 
			@JoinColumn(name = "training_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "skill_id", 
					nullable = false, updatable = false) })
	private List<Skill> skills;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="technology_ID",insertable=false, updatable=false)
	private Technology technology;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "training_payment", joinColumns = { 
			@JoinColumn(name = "training_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "payment_id", 
					nullable = false, updatable = false) })
	private List<Payment> payments;
	
	

	public Integer getAmtToMentor() {
		return amtToMentor;
	}


	public void setAmtToMentor(Integer amtToMentor) {
		this.amtToMentor = amtToMentor;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getProgress() {
		return progress;
	}


	public void setProgress(Integer progress) {
		this.progress = progress;
	}


	public Integer getFees() {
		return fees;
	}


	public void setFees(Integer fees) {
		this.fees = fees;
	}





	public Integer getCommissionPercent() {
		return commissionPercent;
	}


	public void setCommissionPercent(Integer commissionPercent) {
		this.commissionPercent = commissionPercent;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public Integer getAmountRecieved() {
		return amountRecieved;
	}


	public void setAmountRecieved(Integer amountRecieved) {
		this.amountRecieved = amountRecieved;
	}

	
	
	public Integer getTrainingId() {
		return trainingId;
	}


	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getMentorId() {
		return mentorId;
	}


	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}


	public Integer getSkillId() {
		return skillId;
	}


	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}


	public String getRazorpayPaymentId() {
		return razorpayPaymentId;
	}


	public void setRazorpayPaymentId(String razorpayPaymentId) {
		this.razorpayPaymentId = razorpayPaymentId;
	}


	public Mentor getMentors() {
		return mentors;
	}


	public void setMentors(Mentor mentors) {
		this.mentors = mentors;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	public Technology getTechnology() {
		return technology;
	}


	public void setTechnology(Technology technology) {
		this.technology = technology;
	}


	public List<Payment> getPayments() {
		return payments;
	}


	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}


	
	
	
	
	
	

}
