package io.egen.weather_spring_rest.api.repository;

import java.util.List;

import io.egen.weather_spring_rest.api.entity.Weather;

public interface WeatherRepository {
	
	public List<String> getAllCities();
	public Weather getLatestWeatherForCity(String city);
	public String getLatestWeatherPropertyForCity(String property,String City);
	public String getHourlyAverageForCity(String city);
	public String getDailyAverageForCity(String city);
	
}
