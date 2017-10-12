package io.egen.weather_spring_rest.api.repository.impl;

import java.util.List;

import io.egen.weather_spring_rest.api.entity.Weather;
import io.egen.weather_spring_rest.api.repository.WeatherRepository;

public class WeatherRepositoryImpl implements WeatherRepository {

	@Override
	public List<String> getAllCities() {
		return null;
	}

	@Override
	public Weather getLatestWeatherForCity(String city) {
		return null;
	}

	@Override
	public String getLatestWeatherPropertyForCity(String property, String City) {
		return null;
	}

	@Override
	public String getHourlyAverageForCity(String city) {
		return null;
	}

	@Override
	public String getDailyAverageForCity(String city) {
		return null;
	}

}
