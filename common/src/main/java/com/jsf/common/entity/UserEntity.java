package com.jsf.common.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "T_USER")
public class UserEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userID;
	
	@Column(name = "USERNAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String pass;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "CONTACT_NUMBER")
	private String contact;
	
	@Column(name = "REG_DATETIME")
	private String regDate;
	
	@Column(name = "REG_CODE")
	private String regCode;
	
	@Column(name = "FORCE_REST_PASSWORD")
	private Boolean resetPass;
	
	@Column(name = "ACTIVE")
	private Boolean active;
}
