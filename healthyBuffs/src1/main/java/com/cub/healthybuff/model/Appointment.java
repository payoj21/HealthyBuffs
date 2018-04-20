package com.cub.healthybuff.model;

import java.sql.Date;
import java.util.ArrayList;

public class Appointment {
	private int id;
	private int doc_id;
	private int patient_id;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void createAppointment(){
		// DBCall
	}
	
		
}
