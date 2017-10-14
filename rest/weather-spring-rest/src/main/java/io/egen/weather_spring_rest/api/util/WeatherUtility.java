package io.egen.weather_spring_rest.api.util;

import java.util.ArrayList;
import java.util.List;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.entity.Wind;

public class WeatherUtility {
	
	public static List<Weather> hourlyAverageUtility(List<Object[]> results, String city){
		List<Weather> weather = new ArrayList<Weather>();
		
		for(Object [] result: results){
			Weather w = new Weather();
			
		    String dateHour = result[0].toString()+"T"+result[1].toString()+":00:00.000Z";
			w.setTimestamp(dateHour);
		    w.setHumidity(result[2].toString());
			w.setPressure(result[3].toString());
	        w.setTemperature(result[4].toString());
	        w.setDescription("");
	        w.setCity(city);
	        
	        Wind wind = new Wind();
	        wind.setSpeed(result[5].toString());
	        wind.setDegree(result[6].toString());
	        w.setWind(wind);
	        weather.add(w);
		}
		

		return weather;
	}
	
	public static List<Weather> dailyAverageUtility(List<Object[]> results, String city){
		
		List<Weather> weather = new ArrayList<Weather>();
		
		for(Object [] result: results){
			Weather w = new Weather("yyyy-MM-dd");
			w.setTimestamp(result[0].toString());
		    w.setHumidity(result[1].toString());
			w.setPressure(result[2].toString());
	        w.setTemperature(result[3].toString());
	        w.setDescription("");
	        w.setCity(city);
	        
	        Wind wind = new Wind();
	        wind.setSpeed(result[4].toString());
	        wind.setDegree(result[5].toString());
	        w.setWind(wind);
	        
			weather.add(w);
		}	
		return weather;	
	}
}
