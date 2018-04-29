package com.surgeon.eye.services.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surgeon.eye.Repositories.DoctorRepository;
import com.surgeon.eye.Repositories.PatientRepository;
import com.surgeon.eye.model.Doctor;
import com.surgeon.eye.model.Patient;
import com.surgeon.eye.model.Prescription;
import com.surgeon.eye.model.Query;
import com.surgeon.eye.Repositories.QueryRepository;

@Service
public class QueryServiceImpl {
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired 
	QueryRepository queryRepository;
	
	public Patient askQuery(String patientId, String doctorId, Query query) {
		Patient patient = null;
		Doctor doctor = null;

		if( patientId!=null && query!=null && doctorId != null) {
			
//			Doctor doctorAppointmentDetails=	doctorRepository.findByPatientId( prescription.getDoctorId(),patientId);
//			if(null==doctorAppointmentDetails)
//				throw new RuntimeException("No appointment of the patient");
			
//			query=QueryRepository.findOne(patientId, doctorId);
			patient=patientRepository.findOne(patientId);
			doctor = doctorRepository.findOne(doctorId);
			if(null==patient || null == doctor)
				throw new RuntimeException("No such registered patient with us");
			List<Query> patientqueryList=patient.getQueries();
			List<Query> doctorqueryList=doctor.getQueries();
			
			if(patientqueryList==null)
				patientqueryList=new ArrayList<>();
			if(doctorqueryList==null)
				doctorqueryList= new ArrayList<>();
			String s = UUID.randomUUID().toString().replaceAll("-", "");
			String uuid = s.substring(0, Math.min(s.length(), 5));
			query.setQueryId(uuid);
			Date d = new Date();
			query.setTime(d.toString());
			patientqueryList.add(query);
			doctorqueryList.add(query);
			patient.setQueries(patientqueryList);
			doctor.setQueries(doctorqueryList);
			
			
			
			patient=patientRepository.save(patient);
			doctor = doctorRepository.save(doctor);
		}
		return patient;
	}
	
	public List<Query> viewDoctorQueries(String doctorId) {
//		return queryRepository.findByDoctorId(doctorId);
		Doctor doctor = doctorRepository.findOne(doctorId);
		List<Query> queries = doctor.getQueries();
		return queries;
	}
	public List<Query> viewPatientQueries(String patientId) {
//		return queryRepository.findByPatientId(patientId);
		Patient patient = patientRepository.findOne(patientId);
		List<Query> queries = patient.getQueries();
		return queries;
	}
}
