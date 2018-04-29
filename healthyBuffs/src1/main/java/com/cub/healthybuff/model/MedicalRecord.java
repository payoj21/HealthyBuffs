package com.cub.healthybuff.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class MedicalRecord {
	private int id;
	private int patient_id;
	private int doc_id;
	private Date date;
	private String comment;
	private String presciption;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPresciption() {
		return presciption;
	}
	public void setPresciption(String presciption) {
		this.presciption = presciption;
	}
	
}
