package com.jsf.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "T_SKILLS")
public class SkillEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long skillID;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TOC")
	private String toc;
	
	@Column(name = "DURATION")
	private String duration;
	
	@Column(name = "PREREQUITES")
	private String preRequites;
	
}
