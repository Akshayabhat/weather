package io.egen.weather_spring_rest.api.service;

import java.util.List;

import io.egen.weather_spring_rest.api.entity.Weather;

public interface WeatherService {
	
	public Weather create(Weather weather);
	public List<String> getAllCities();
	public Weather getLatestWeatherForCity(String city);
	public String getLatestWeatherPropertyForCity(String property,String City);
	public List<Weather> getHourlyAverageForCity(String city);
	public List<Weather> getDailyAverageForCity(String city);
	
	
}
