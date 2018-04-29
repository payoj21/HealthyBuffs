package com.surgeon.eye.controller;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surgeon.eye.model.Patient;
import com.surgeon.eye.model.Prescription;
import com.surgeon.eye.services.impl.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientServiceImpl patientServiceImpl;

	@RequestMapping(value="/saveprescription", method=RequestMethod.POST)
	public Patient savePrescription(@RequestBody Prescription prescription,
			@RequestParam("patientId") String patientId) {
		Patient patient =patientServiceImpl.savePrescription(prescription, patientId);
			return patient;
		}
	
	@RequestMapping(value="/getprescription", method=RequestMethod.GET)
	public List<Prescription> getPrescription(
			@RequestParam("patientId") String patientId) {
		List<Prescription> prescription =patientServiceImpl.getPrescription( patientId);
		
			return prescription;
	}
}
