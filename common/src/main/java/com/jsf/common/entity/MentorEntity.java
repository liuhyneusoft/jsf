package com.jsf.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "T_MENTOR")
public class MentorEntity {

	@Id
	@Column(name = "ID")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mentorID;
	
	@Column(name = "USERNAME")
	private String name;
	
	@Column(name = "LINKEDIN_URL")
	private String url;
	
	@Column(name = "REG_DATETIME")
	private Date regDate;
	
	@Column(name = "REG_CODE")
	private String regCode;
	
	@Column(name = "YEARS_OF_EXPERIENCE")
	private String experience;
	
	@Column(name = "ACTIVE")
	private Boolean active;
	
}
