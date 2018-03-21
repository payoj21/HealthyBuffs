package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

      
	public static Session getSessionFromFactory() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
		
		//creating seession factory object
		SessionFactory factory=cfg.buildSessionFactory();
		return factory.openSession();
	}
	

}
