package io.egen.weather_spring_rest.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.exception.NotFoundException;
import io.egen.weather_spring_rest.api.repository.WeatherRepository;
import io.egen.weather_spring_rest.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository){
		this.repository = repository;
	}
	
	@Override
	public Weather create(Weather weather){
		return repository.create(weather);
	}
	
	@Override
	public List<String> getAllCities() {
		return repository.getAllCities();
	}
    
	@Override
	public Weather getLatestWeatherForCity(String city) {
		Weather existing = repository.getLatestWeatherForCity(city);
		if(existing == null)
		{
			throw new NotFoundException("City "+city+" not found");
		}
		return existing;
	}

	@Override
	public String getLatestWeatherPropertyForCity(String property, String city) {
		String existing = repository.getLatestWeatherPropertyForCity(property, city);
		if(existing.isEmpty()){
			
			throw new NotFoundException("City "+city+" and/or property " + property +" not found");
		}
		
		return existing;
	}

	@Override
	public List<Weather> getHourlyAverageForCity(String city) {
		List<Weather> existing = repository.getHourlyAverageForCity(city);
		if(existing == null){
			throw new NotFoundException("City "+city+" not found");
		}
		return existing;
	}

	@Override
	public List<Weather> getDailyAverageForCity(String city) {
		List<Weather> existing = repository.getDailyAverageForCity(city);
		if(existing.isEmpty()){
			throw new NotFoundException("City "+city+" not found");
		}
		return existing;
	}

}
