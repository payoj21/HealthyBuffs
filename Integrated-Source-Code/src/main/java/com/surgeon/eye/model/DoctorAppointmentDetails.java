package com.surgeon.eye.model;

import java.util.Date;

import lombok.Data;

@Data
public class DoctorAppointmentDetails {
	
	private String recordId;
	private String patientId;
	private String patientName;
	private int patientAge;
	private String pateintGender;
	private Date date;
	
	

}
