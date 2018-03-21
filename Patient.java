package models;

import java.util.ArrayList;

public class Patient extends User{
	private String patient_id;
	protected String gender;
	protected int age;
	private ArrayList <Appointment> appointment;
	public ArrayList<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(ArrayList<Appointment> appointment) {
		this.appointment = appointment;
	}

	public String name;
	public ArrayList <Address> addr;
	public String email;
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Address> getAddr() {
		return addr;
	}
	public void setAddr(ArrayList<Address> addr) {
		this.addr = addr;
	}
	
	public void viewMedicalRecord(){
		
	}

}
