package com.surgeon.eye.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="pharmacists")
public class Pharmacist {
	
	@Id
	private String id;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
//	private String speciality;
	private String officeHours;
	private List<PharmacistAppointmentDetails> appointments;

}

