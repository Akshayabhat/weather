package io.egen.weather_spring_rest.api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.service.WeatherService;
import io.swagger.annotations.*;
import io.egen.weather_spring_rest.api.constants.URI;
@RestController
@RequestMapping(value= URI.WEATHER)
@Api(tags="weather")
public class WeatherController {
	
	private WeatherService service;
	
	public WeatherController(WeatherService service){
		this.service = service;
	}
	
	
	@ApiOperation(value="Create weather reading", notes="Creates a reading")
	@ApiResponses(value={
	@ApiResponse(code=200,message="Success"),
	@ApiResponse(code=500, message="Internal Server Error"),
	})
	@RequestMapping(method=RequestMethod.POST)
	public Weather create(@RequestBody Weather weather){
		return service.create(weather);
	}
	
	
	@ApiOperation(value="Get cities", notes="Gets a list of cities")
	@ApiResponses(value={
	@ApiResponse(code=200,message="Success"),
	@ApiResponse(code=500, message="Internal Server Error"),
	})
	@RequestMapping(method=RequestMethod.GET,value=URI.CITIES)
	public List<String> getAllCities(){
		return service.getAllCities();
	}
	
	
	@ApiOperation(value="Get latest reading for city", notes="Gets latest weather reading for given city")
	@ApiResponses(value={
	@ApiResponse(code=200,message="Success"),
	@ApiResponse(code=404,message="Not Found"),
	@ApiResponse(code=500, message="Internal Server Error"),
	})
	@RequestMapping(method=RequestMethod.GET,value=URI.LATEST_WEATHER_FOR_CITY)
	public Weather getLatestWeatherForCity(@PathVariable("city") String city){
		return service.getLatestWeatherForCity(city);
	}
	
	@ApiOperation(value="Get latest property for ciy", notes="Gets latest property specified for a given city")
	@ApiResponses(value={
	@ApiResponse(code=200,message="Success"),
	@ApiResponse(code=404,message="Not Found"),
	@ApiResponse(code=500, message="Internal Server Error"),
	})
	@RequestMapping(method=RequestMethod.GET,value=URI.LATEST_PROPERTY_WEATHER_FOR_CITY)
	public String getLatestWeatherPropertyForCity(@PathVariable("property") String property, @PathVariable("city") String city){
		return service.getLatestWeatherPropertyForCity(property, city);
	}
	
	@ApiOperation(value="Get hourly average for city", notes="Gets average weather readings by hour for a given city")
	@ApiResponses(value={
	@ApiResponse(code=200,message="Success"),
	@ApiResponse(code=404,message="Not Found"),
	@ApiResponse(code=500, message="Internal Server Error"),
	})
	@RequestMapping(method=RequestMethod.GET,value=URI.HOURLY_AVG_FOR_CITY)
	public List<Weather> getHourlyAverageForCity(@PathVariable("city") String city){
		return service.getHourlyAverageForCity(city);
	}
	
	@ApiOperation(value="Get daily average for city", notes="Gets average weather readings by day for a given city")
	@ApiResponses(value={
	@ApiResponse(code=200,message="Success"),
	@ApiResponse(code=404,message="Not Found"),
	@ApiResponse(code=500, message="Internal Server Error"),
	})
	@RequestMapping(method=RequestMethod.GET,value=URI.DAILY_AVG_FOR_CITY)
	public List<Weather> getDailyAverageForCity(@PathVariable("city") String city){
		return service.getDailyAverageForCity(city);
	}
}
