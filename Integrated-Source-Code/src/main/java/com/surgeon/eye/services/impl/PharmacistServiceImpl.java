package com.surgeon.eye.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.surgeon.eye.Repositories.PharmacistRepository;
import com.surgeon.eye.Repositories.PatientRepository;
import com.surgeon.eye.model.Pharmacist;
import com.surgeon.eye.model.PharmacistAppointmentDetails;
import com.surgeon.eye.model.Patient;

@Service
public class PharmacistServiceImpl {

	@Autowired
	PharmacistRepository pharmacistRepository;
	
	@Autowired
	PatientRepository patientRepository;


	public Pharmacist saveAppointment(PharmacistAppointmentDetails appointmentDetails, String pharmaId) {
		Pharmacist pharmacist=null;
	
		if( pharmaId!=null && appointmentDetails!=null) {
			pharmacist =	pharmacistRepository.findOne(pharmaId);
			if(pharmacist==null)
				throw new RuntimeException("No Pathologist found");
			if(appointmentDetails.getPatientId()==null)
				throw new IllegalArgumentException("Invalid patient Id");
			else {
				Patient patient= patientRepository.findOne(appointmentDetails.getPatientId());
				if(patient==null)
					throw new RuntimeException("No patient found");

				if(CollectionUtils.isEmpty(pharmacist.getAppointments())) {
					String s = UUID.randomUUID().toString().replaceAll("-", "");
					String uuid = s.substring(0, Math.min(s.length(), 5));
					appointmentDetails.setRecordId(uuid);
					pharmacist.getAppointments().add(appointmentDetails);
					pharmacist= pharmacistRepository.save(pharmacist);
				}
				else {
					// 15 mins. record id. office hours check. 
					pharmacist.getAppointments().stream().forEach(appointment->{
						if(appointment.getDate().equals(appointmentDetails.getDate())) {
							throw new RuntimeException("Slot unavailable");
						}
					});
					String s = UUID.randomUUID().toString().replaceAll("-", "");
					String uuid = s.substring(0, Math.min(s.length(), 5));
					appointmentDetails.setRecordId(uuid);
					pharmacist.getAppointments().add(appointmentDetails);
					pharmacist= pharmacistRepository.save(pharmacist);
					List <PharmacistAppointmentDetails> app = pharmacist.getAppointments();
					for(int i = 0;i< app.size(); i++) {
//						String id = app.get(i).getRecordId();
						
//						if (id == uuid) {
//						new Date("<YYYY-mm-ddTHH:MM:ss>") date =  app.get(i).getDate();
						String pattern = "yyyy-MM-dd|HH:MM:ss";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//						}
					
					}
					
					
					
					
				}
			}
		}
		else
			throw new IllegalArgumentException("Invalid Request");


		return pharmacist;
	}
	
	public List<Pharmacist> getPharmacists(String name){
	return	pharmacistRepository.findByName(name);
		
	}
}
