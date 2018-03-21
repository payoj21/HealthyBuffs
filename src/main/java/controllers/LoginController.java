package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import models.Login;
import models.Patient;
import models.Staff;
import models.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@Controller
public class LoginController {
	
   @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
   public ModelAndView patient() {
      return new ModelAndView("loginPage", "command", new Login());
   }
   
   @RequestMapping(value = "/loginPagePost", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("MVCSpring")Login login, 
      ModelMap model) {
	 
	   	   Session session = HibernateUtil.getSessionFromFactory();

		//login.setPassword("encrypted");
/*		
 		Patient patient = null;
		patient = (Patient)session.get(Patient.class, login.getLogin_id());
		if(patient != null) {
			login.setType("Patient");
		}
		else {
			login.setType("Doctor");
		}
*/
		
		//login.setType("Patient");
		//creating transaction object
		//Transaction t=session.beginTransaction();
		//session.persist(login);//persisting the object
		
		//t.commit();//transaction is committed
		//session.close();
      
      //model.addAttribute("type", login.getType());
      Transaction t=session.beginTransaction();
      Login checkLogin = (Login)session.get(Login.class, login.getLogin_id());//getting the object
		
		t.commit();//transaction is committed
		model.addAttribute("login_id", login.getLogin_id());
	      model.addAttribute("password", login.getPassword());
		//session.close();
		//System.out.println(checkLogin.getPassword() + "\t" + login.getPassword());
	  if(checkLogin.getPassword().equals(login.getPassword())) {
	    	  
	      
	      // change this to the portal of the specific type
	     // String type = login.getType();
	      if(checkLogin.getLogin_id().charAt(0) == 'P') {
	    	  Patient patient = null;
	    	  patient = (Patient)session.get(Patient.class, checkLogin.getLogin_id());
	    	  if(patient != null) {
	    		  model.addAttribute("name", patient.getName());
	    		  return "result_login_patient";
	    	  }
	      }
	      else if(checkLogin.getLogin_id().charAt(0) == 'D') {
	    	  Staff staff = null;
	    	  staff = (Staff)session.get(Staff.class, checkLogin.getLogin_id());
		      model.addAttribute("name", staff.getName());
		      return "doctorPage";
		  }
	      else if(checkLogin.getLogin_id().charAt(0) == 'H') {
	    	  Staff staff = null;
	    	  staff = (Staff)session.get(Staff.class, checkLogin.getLogin_id());
		      model.addAttribute("name", staff.getName());
		      return "pharmacistPage";
		  }
	      else if(checkLogin.getLogin_id().charAt(0) == 'R') {
	    	  Staff staff = null;
	    	  staff = (Staff)session.get(Staff.class, checkLogin.getLogin_id());
		      model.addAttribute("name", staff.getName());
		      return "receptionistPage";
		  }
	      else if(checkLogin.getLogin_id().charAt(0) == 'N') {
	    	  Staff staff = null;
	    	  staff = (Staff)session.get(Staff.class, checkLogin.getLogin_id());
		      model.addAttribute("name", staff.getName());
		      return "nursePage";
		  }
	      else if(checkLogin.getLogin_id().charAt(0) == 'A') {
	    	  Staff staff = null;
	    	  staff = (Staff)session.get(Staff.class, checkLogin.getLogin_id());
		      model.addAttribute("name", staff.getName());
		      return "accountantPage";
		  }
	      
	      
	  }
	  
	  
	 // model.addAttribute("name", patient.getName());
	  //return "result_login_doctor";
	  return "result_login_error";
	  

   }
}
