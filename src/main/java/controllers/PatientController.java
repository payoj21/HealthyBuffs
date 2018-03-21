package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import models.Patient;

import java.util.Random;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@Controller
public class PatientController {
	
   @RequestMapping(value = "/receptionistPatientUpload", method = RequestMethod.GET)
   public ModelAndView patient() {
      return new ModelAndView("receptionistPatientUpload", "command", new Patient());
   }
   
   @RequestMapping(value = "/receptionistPatientUploadPost", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("MVCSpring")Patient patient, 
      ModelMap model) {
	
	   	Session session = HibernateUtil.getSessionFromFactory();

		Random random = new Random();
		patient.setPatient_id("P" + (random.nextInt(90000 - 10000 + 1) + 10000));
		
		//creating transaction object
		Transaction t=session.beginTransaction();
		session.persist(patient);//persisting the object
		
		t.commit();//transaction is commited
		session.close();
      model.addAttribute("name", patient.getName());
      model.addAttribute("age", patient.getAge());
      model.addAttribute("patient_id", patient.getPatient_id());
      
      
      return "result";
   }
}
