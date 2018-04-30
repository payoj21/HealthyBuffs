package com.surgeon.eye.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.surgeon.eye.Repositories.DoctorRepository;
import com.surgeon.eye.Repositories.PatientRepository;
import com.surgeon.eye.model.Doctor;
import com.surgeon.eye.model.DoctorAppointmentDetails;
import com.surgeon.eye.model.Patient;
import com.surgeon.eye.model.DoctorBySpeciality;

@Service
public class DoctorServiceImpl {

	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;


	public Doctor saveAppointment(DoctorAppointmentDetails appointmentDetails, String doctorId) {
		Doctor doctor=null;
	
		if( doctorId!=null && appointmentDetails!=null) {
			doctor =	doctorRepository.findOne(doctorId);
			if(doctor==null)
				throw new RuntimeException("No doctor found");
			if(appointmentDetails.getPatientId()==null)
				throw new IllegalArgumentException("Invalid patient Id");
			else {
				Patient patient= patientRepository.findOne(appointmentDetails.getPatientId());
				if(patient==null)
					throw new RuntimeException("No patient found");

				if(CollectionUtils.isEmpty(doctor.getAppointments())) {
					String s = UUID.randomUUID().toString().replaceAll("-", "");
					String uuid = s.substring(0, Math.min(s.length(), 5));
					appointmentDetails.setRecordId(uuid);
					doctor.getAppointments().add(appointmentDetails);
					doctor= doctorRepository.save(doctor);
				}
				else {
					// 15 mins. record id. office hours check. 
					doctor.getAppointments().stream().forEach(appointment->{
						if(appointment.getDate().equals(appointmentDetails.getDate())) {
							throw new RuntimeException("Slot unavailable");
						}
					});
					String s = UUID.randomUUID().toString().replaceAll("-", "");
					String uuid = s.substring(0, Math.min(s.length(), 5));
					appointmentDetails.setRecordId(uuid);
					doctor.getAppointments().add(appointmentDetails);
					doctor= doctorRepository.save(doctor);
//					List <DoctorAppointmentDetails> app = doctor.getAppointments();
//					for(int i = 0;i< app.size(); i++) {
////						String id = app.get(i).getRecordId();
//						
////						if (id == uuid) {
////						new Date("<YYYY-mm-ddTHH:MM:ss>") date =  app.get(i).getDate();
//						String pattern = "yyyy-MM-dd|HH:MM:ss";
//						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
////						}
//					
//					}
					
					
					
					
				}
			}
		}
		else
			throw new IllegalArgumentException("Invalid Request");


		return doctor;
	}
	
	public List<DoctorBySpeciality> getDoctors(String speciality){
		List<DoctorBySpeciality>doctorsList =	doctorRepository.findBySpeciality(speciality);
		
		
		return doctorsList;
	}
	public List<DoctorAppointmentDetails>viewAppointments(String doctorId){
		Doctor doctor = null;
		doctor = 	doctorRepository.findOne(doctorId);
		return doctor.getAppointments();
	}
}
