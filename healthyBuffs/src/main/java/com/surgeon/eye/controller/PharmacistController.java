package com.surgeon.eye.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surgeon.eye.model.Pharmacist;
import com.surgeon.eye.model.PharmacistAppointmentDetails;
import com.surgeon.eye.services.impl.PharmacistServiceImpl;

@RestController
@RequestMapping("/pharmacist")
public class PharmacistController {
	
	@Autowired
	PharmacistServiceImpl pharmacistServiceImpl;
	
	@RequestMapping(value="/bookappointment", method=RequestMethod.POST)
	public Pharmacist bookAppointment(@RequestBody PharmacistAppointmentDetails appointmentDetails,
			@RequestParam("pharmacistId") String pharmacistId) {
		Pharmacist pharmacist =pharmacistServiceImpl.saveAppointment(appointmentDetails, pharmacistId);
			return pharmacist;
		}
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public List <Pharmacist> getPharmacists(@RequestParam("name") String name) {
		List<Pharmacist> pharmaList = pharmacistServiceImpl.getPharmacists(name);
			return pharmaList;
		}
}

