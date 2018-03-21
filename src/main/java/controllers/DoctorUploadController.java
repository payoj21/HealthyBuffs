package controllers;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import models.Prescription;
import models.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@Controller
public class DoctorUploadController {
	
	
   @RequestMapping(value = "/doctorPrescriptionUpload", method = RequestMethod.GET)
   public ModelAndView patient() {
	  
      return new ModelAndView("doctorPrescriptionUpload", "command", new Prescription());
   }
   
   @RequestMapping(value = "/doctorPrescriptionUploadPost", method = RequestMethod.POST)
   public String addPrescription(@ModelAttribute("MVCSpring")Prescription press, 
      ModelMap model) {
	        
		Session session=HibernateUtil.getSessionFromFactory();
		Patient p=null;
		p = (Patient)session.get(Patient.class, press.getPatient_id());
		press.setCurrent_temperature(p.getMost_recent_temperature());
		press.setCurrent_pressure(p.getMost_recent_pressure());
		//creating transaction object
		Transaction t=session.beginTransaction();
		
		session.persist(press);//persisting the object
		
		t.commit();//transaction is commited
		session.close();
      model.addAttribute("patient_id", press.getPatient_id());
      model.addAttribute("patient_name", p.getName());
      model.addAttribute("prescription_id", press.getPrescription_id());
      model.addAttribute("inventory_id_1", press.getInventory_id_1());
      model.addAttribute("inventory_id_2", press.getInventory_id_2());
      model.addAttribute("inventory_id_3", press.getInventory_id_3());
      model.addAttribute("inventory_id_4", press.getInventory_id_4());
      model.addAttribute("inventory_id_5", press.getInventory_id_5());
      model.addAttribute("current_temperature", press.getCurrent_temperature());
      model.addAttribute("current_pressure", press.getCurrent_pressure());
      
      
      return "result_prescription";
   }
}
