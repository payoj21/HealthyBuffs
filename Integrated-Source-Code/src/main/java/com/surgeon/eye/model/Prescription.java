package com.surgeon.eye.model;

import java.util.Date;

import lombok.Data;
@Data
public class Prescription {
	private Date appointmentDate;
	private String recordId;
	private String doctorId;
	private String prescription;
	

}
