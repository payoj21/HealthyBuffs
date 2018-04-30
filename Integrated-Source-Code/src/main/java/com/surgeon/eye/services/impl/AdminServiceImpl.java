//package com.surgeon.eye.services.impl;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.surgeon.eye.Repositories.AdminRepository;
////import com.surgeon.eye.Repositories.AdminRepository;
//import com.surgeon.eye.model.Admin;
//import com.surgeon.eye.model.Patient;
//import com.surgeon.eye.model.Prescription;
//
//@Service
//public class AdminServiceImpl {
//	
//	@Autowired
//	AdminRepository adminRepository;
//	
////	@Autowired
////	DoctorRepository doctorRepository;
//	
//	public Patient savePrescription(Prescription prescription, String patientId) {
//		Patient patient=null;
//		
//		if( patientId!=null && prescription!=null) {
//			Doctor doctorAppointmentDetails=	doctorRepository.findByPatientId( prescription.getDoctorId(),patientId);
//			if(null==doctorAppointmentDetails)
//				throw new RuntimeException("No appointment of the patient");
//			
//			patient=patientRepository.findOne(patientId);
//			if(null==patient)
//				throw new RuntimeException("No such registered patient with us");
//			List<Prescription> prescriptionList=patient.getPrescriptions();
//			if(prescriptionList==null)
//				prescriptionList=new ArrayList<>();
//			prescriptionList.add(prescription);
//			patient.setPrescriptions(prescriptionList);
//			
//			patient=patientRepository.save(patient);
//			
//		}
//		
//		return patient;
//	}
//	
//	public List<Prescription> getPrescription( String patientId) {
//		 List<Prescription>prescription=null;
//		if( patientId!=null) {
//			Patient	patient=patientRepository.findOne(patientId);
//			if(null==patient)
//				throw new RuntimeException("No such registered patient with us");
//			else
//				prescription=patient.getPrescriptions();
//		}
//		
//			return prescription;
//		
//		
//	}
//
//}
//
//public class AdminServiceImpl {
//	
//}
