package models;

import java.util.ArrayList;

public class Doctor {
	private String specialisation;
	private float experience;
	private int affiliation_no;
	private ArrayList <Appointment> appointment;
	protected String schedule;
	private String id;
	public String name;
	public ArrayList <Address> addr;
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public float getExperience() {
		return experience;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	public int getAffiliation_no() {
		return affiliation_no;
	}
	public void setAffiliation_no(int affiliation_no) {
		this.affiliation_no = affiliation_no;
	}
	public ArrayList<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(ArrayList<Appointment> appointment) {
		this.appointment = appointment;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Address> getAddr() {
		return addr;
	}
	public void setAddr(ArrayList<Address> addr) {
		this.addr = addr;
	}
}
