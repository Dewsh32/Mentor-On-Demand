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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="skill")
public class Skill extends AuditModel{
	
	
	private static final long serialVersionUid=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="toc",nullable=false)
	private String toc;
	
	
	@Column(name="prerequisites",nullable=false)
	private String prerequisites;

	
	@Column(name="mentor_id")
	private Integer mentorId;

	
	
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getToc() {
		return toc;
	}


	public void setToc(String toc) {
		this.toc = toc;
	}


	public String getPrerequisites() {
		return prerequisites;
	}


	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}


	public Integer getMentorId() {
		return mentorId;
	}


	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}
	
	
	

}
