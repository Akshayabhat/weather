package io.egen.weather_spring_rest.api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.service.WeatherService;

@RestController
@RequestMapping(value="/weather")
public class WeatherController {
	
	private WeatherService service;
	
	public WeatherController(WeatherService service){
		this.service = service;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Weather create(@RequestBody Weather weather){
		return service.create(weather);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/cities")
	public List<String> getAllCities(){
		return service.getAllCities();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/latest/{city}")
	public Weather getLatestWeatherForCity(@PathVariable("city") String city){
		return service.getLatestWeatherForCity(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/latest/{city}/{property}")
	public String getLatestWeatherPropertyForCity(@PathVariable("property") String property, @PathVariable("city") String city){
		return service.getLatestWeatherPropertyForCity(property, city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/hourly-avg/{city}")
	public List<Weather> getHourlyAverageForCity(@PathVariable("city") String city){
		return service.getHourlyAverageForCity(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/daily-avg/{city}")
	public List<Weather> getDailyAverageForCity(@PathVariable("city") String city){
		return service.getDailyAverageForCity(city);
	}
}
