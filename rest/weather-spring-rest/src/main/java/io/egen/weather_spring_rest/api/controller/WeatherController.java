package io.egen.weather_spring_rest.api.controller;


import java.util.List;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.service.WeatherService;

public class WeatherController {
	
	private WeatherService service;
	
	public WeatherController(WeatherService service){
		this.service = service;
	}

	public List<String> getAllCities(){
		return null;
	}
	
	public Weather getLatestWeatherForCity(String city){
		return null;
	}
	
	public String getLatestWeatherPropertyForCity(String property,String City){
		return null;
	}
	
	public String getHourlyAverageForCity(String city){
		return null;
	}
	
	public String getDailyAverageForCity(String city){
		return null;
	}
}
