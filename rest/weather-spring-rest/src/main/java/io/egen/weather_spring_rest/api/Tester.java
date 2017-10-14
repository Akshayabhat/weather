package io.egen.weather_spring_rest.api;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.entity.Wind;

public class Tester {
	
	public static void main (String [] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");

		
		EntityManager em = emf.createEntityManager();
		
		Weather weather1 = new Weather();
		weather1.setCity("Chicago");
		weather1.setDescription("whatevs");
		weather1.setHumidity("232");
		weather1.setTemperature("324");
		weather1.setPressure("123");
		
		Wind wind1 = new Wind();
		wind1.setDegree("23");
		wind1.setSpeed("234");
		
		em.getTransaction().begin();
		em.persist(wind1);
		weather1.setWind(wind1);
		em.persist(weather1);
		em.getTransaction().commit();
		
		//---
		
		Weather weather2 = new Weather();
		weather1.setCity("SF");
		weather1.setDescription("whatevs");
		weather1.setHumidity("242");
		weather1.setTemperature("243");
		weather1.setPressure("342");
		
		Wind wind2 = new Wind();
		wind1.setDegree("53");
		wind1.setSpeed("43");
		
		em.getTransaction().begin();
		em.persist(wind2);
		weather1.setWind(wind2);
		em.persist(weather2);
		em.getTransaction().commit();
		
		
		//ONE TO ONE:		
//		User user1 = new User();
//		user1.setFirstName("Ron");
//		user1.setLastName("Weasley");
//	
//		Address address1 = new Address();
//		address1.setStreet("2323 random");
//		address1.setCity("Emeryville");
//		address1.setState("CA");
//		address1.setZipcode("834234");
//		
//	
//		
//		em.getTransaction().begin();
//		em.persist(address1);
//		user1.setAddress(address1);
//		em.persist(user1);
//		em.getTransaction().commit();
//		

	//	User user = em.find(User.class,"8955e34a-44f9-4a1b-82af-a0df7d9375d8");
	//	System.out.println(user);
		em.close();
		
	}

}
