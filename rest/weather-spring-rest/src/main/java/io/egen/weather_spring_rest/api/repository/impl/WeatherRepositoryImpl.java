package io.egen.weather_spring_rest.api.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.entity.Wind;
import io.egen.weather_spring_rest.api.repository.WeatherRepository;
import io.egen.weather_spring_rest.api.util.WeatherUtility;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<String> getAllCities() {
		TypedQuery <String>query = em.createNamedQuery("Weather.getAllCities",String.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public Weather create(Weather weather){
		em.persist(weather);
		return weather;
	}

	@Override
	public Weather getLatestWeatherForCity(String city) {
		TypedQuery <Weather>query = em.createNamedQuery("Weather.getLatestWeatherForCity",Weather.class);
		query.setParameter("pcity", city);
		System.out.println(city);
		List<Weather> cityWeather = query.getResultList();
		System.out.println(cityWeather.get(0));
		return cityWeather.get(0);
	}

	@Override
	public String getLatestWeatherPropertyForCity(String property, String city) {
		TypedQuery <Weather>query = em.createNamedQuery("Weather.getLatestWeatherPropertyForCity",Weather.class);
		query.setParameter("pcity", city);
		List<Weather> cityWeather = query.getResultList();
		if(cityWeather.isEmpty()) return null;
		Weather latestWeather = cityWeather.get(0);
		if(property.equalsIgnoreCase("temperature"))
			return latestWeather.getTemperature();
		else if(property.equals("humidity"))
				return latestWeather.getHumidity();
		else if(property.equalsIgnoreCase("pressure"))
				return latestWeather.getPressure();
		else
			// property invalid
			return "";		
		}
	
	@Override
	public List<Weather> getHourlyAverageForCity(String city) {
		Query query = em.createNamedQuery("Weather.getHourlyAverage");
	    query.setParameter("pcity", city);
	    List<Object[]> results = query.getResultList();
	    return WeatherUtility.hourlyAverageUtility(results,city);
    
	}
    
	@Override
	public List<Weather> getDailyAverageForCity(String city) {
		
		Query query = em.createNamedQuery("Weather.getDailyAverage");
	    query.setParameter("pcity", city);
	    List<Object[]> results = query.getResultList();
	    return WeatherUtility.dailyAverageUtility(results,city);	}

}
