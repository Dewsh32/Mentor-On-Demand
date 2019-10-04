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
@Table(name="user")
public class User  extends AuditModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	

	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="reg_code")
	private String regCode="";
	
	@Column(name="role")
	private String role="user";
	
	@Column(name="linkedin_url")
	private String linkedinUrl=null;
	
	@Column(name="years_of_experience")
	private String yearsofexperience;
	
	@Column(name="active")
	private Boolean active=true;
	
	@Column(name="confirmed_signup")
	private Boolean confirmedSignUp=true;
	
	@Column(name="reset_password")
	private Boolean resetPassword=false;
	
	@Column(name="reset_password_date")
	private String resetPasswordDate;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getYearsofexperience() {
		return yearsofexperience;
	}

	public void setYearsofexperience(String yearsofexperience) {
		this.yearsofexperience = yearsofexperience;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getConfirmedSignUp() {
		return confirmedSignUp;
	}

	public void setConfirmedSignUp(Boolean confirmedSignUp) {
		this.confirmedSignUp = confirmedSignUp;
	}

	public Boolean getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(Boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public String getResetPasswordDate() {
		return resetPasswordDate;
	}

	public void setResetPasswordDate(String resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
	

}
