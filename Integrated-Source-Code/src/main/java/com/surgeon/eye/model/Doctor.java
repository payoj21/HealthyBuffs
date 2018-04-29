package com.surgeon.eye.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="doctors")
public class Doctor {
	
	@Id
	private String id;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String speciality;
	private String officeHours;
	private List<DoctorAppointmentDetails> appointments;

}
