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
@Table(name = "T_PAYMENT")
public class PaymentEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userID;
	 
	@OneToOne
	@JoinColumn(name = "MENTOR_ID")
	private MentorEntity mentor;
	
	@OneToOne
	@JoinColumn(name = "TRAINING_ID")
	private TrainEntity train;

	@Column(name = "TXN_TYPE")
	private String txnType;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@Column(name = "PAY_DATE")
	private Date payDate;
	
	@Column(name = "REMARKS")
	private String remark;
}
