package com.jsf.common.param;

 
import lombok.Data;

@Data
public class TrainParam {

	private Long userID;
	private Long mentorID;
	private String skill;
	private String status;
	private String startDate;
	private String endDate;
}
