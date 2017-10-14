package io.egen.weather_spring_rest.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.repository.WeatherRepository;
import io.egen.weather_spring_rest.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository){
		this.repository = repository;
	}
	
	@Override
	public List<String> getAllCities() {
		return repository.getAllCities();
	}
    
	@Override
	public Weather create(Weather weather){
		return repository.create(weather);
	}
	@Override
	public Weather getLatestWeatherForCity(String city) {
		Weather existing = repository.getLatestWeatherForCity(city);
		if(existing == null)
		{
			//throw not found exception
		}
		return existing;
	}

	@Override
	public String getLatestWeatherPropertyForCity(String property, String City) {
		String existing = repository.getLatestWeatherPropertyForCity(property, City);
		if(existing.isEmpty()){
			// throw not found exception
		}
		
		return existing;
	}

	@Override
	public List<Weather> getHourlyAverageForCity(String city) {
		List<Weather> existing = repository.getHourlyAverageForCity(city);
		if(existing == null){
			// throw not found exception
		}
		return existing;
	}

	@Override
	public List<Weather> getDailyAverageForCity(String city) {
		List<Weather> existing = repository.getDailyAverageForCity(city);
		if(existing.isEmpty()){
			
		}
		return existing;
	}

}
