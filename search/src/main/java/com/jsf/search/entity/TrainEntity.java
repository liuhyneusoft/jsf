package com.jsf.search.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "T_TRAINING")
public class TrainEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trainID;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity user;
	
	@OneToOne
	@JoinColumn(name = "MENTOR_ID")
	private MentorEntity mentor;
	
	@OneToOne
	@JoinColumn(name = "SKILL_ID")
	private SkillEntity skill;
	
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "PROCESS")
	private String process;
	
	@Column(name = "RATING")
	private Double rate;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "AMOUNT_RECEIVED")
	private Double amount;
}
