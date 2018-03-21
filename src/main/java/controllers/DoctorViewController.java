package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import models.Patient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



@Controller
public class DoctorViewController {
	
   @RequestMapping(value = "/doctorVitalsView", method = RequestMethod.GET)
   public ModelAndView patient() {
      return new ModelAndView("doctorVitalsView", "command", new Patient());
   }
   
   @RequestMapping(value = "/doctorVitalsViewPost", method = RequestMethod.POST)
   public String addPatient(@ModelAttribute("MVCSpring")Patient patient, 
      ModelMap model) {
	
	   	Session session = HibernateUtil.getSessionFromFactory();

		
		//creating transaction object
		Transaction t=session.beginTransaction();
		Patient p = null;
		p = (Patient)session.get(Patient.class, patient.getPatient_id());
		
		session.update(p);
		//session.persist(patient);//persisting the object
		
		t.commit();//transaction is commited
		session.close();
      model.addAttribute("name", p.getName());
      model.addAttribute("age", p.getAge());
      model.addAttribute("patient_id", p.getPatient_id());
      model.addAttribute("most_recent_temperature", p.getMost_recent_temperature());
      model.addAttribute("most_recent_pressure", p.getMost_recent_pressure());
      
      return "result";
   }
}
