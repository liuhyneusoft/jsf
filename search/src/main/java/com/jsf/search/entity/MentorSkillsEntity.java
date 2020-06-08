package com.jsf.search.entity;

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
@Table(name = "T_MENTOR_SKILLS")
public class MentorSkillsEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mentorCaleID;
	
	@OneToOne
	@JoinColumn(name = "MID")
	private MentorEntity mentor;
	
	@Column(name = "SELF_RATING")
	private Double rate;
	
	@Column(name = "YEAR_OF_EXP")
	private Integer exp;
	
	@Column(name = "TRAININGS_DELIVERED")
	private String delivered;
	
	@Column(name = "FACILITIES_OFFERED")
	private String offered;
	
	@Column(name = "SKILL_NAME")
	private String skillName;
	 
}
