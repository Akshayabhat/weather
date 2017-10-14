package io.egen.weather_spring_rest.api.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery (name="Weather.getAllCities", query="SELECT DISTINCT w.city from Weather w"),
	@NamedQuery (name="Weather.getLatestWeatherForCity", query="SELECT w from Weather w where w.city=:pcity order by w.timestamp desc"),
	@NamedQuery (name="Weather.getLatestWeatherPropertyForCity", query="SELECT w from Weather w where w.city=:pcity order by w.timestamp desc"),
	@NamedQuery (name="Weather.getDailyAverage", query="Select date(w.timestamp), avg(w.humidity), avg(w.pressure), avg(w.temperature), avg(wi.speed), avg(wi.degree)" +
														"from Weather w JOIN w.wind wi where w.city=:pcity group by 1"),
	@NamedQuery (name="Weather.getHourlyAverage", query="Select date(w.timestamp), DATE_FORMAT(w.timestamp,'%H') as hour, avg(w.humidity), avg(w.pressure), avg(w.temperature), avg(wi.speed), avg(wi.degree)" +
			"from Weather w JOIN w.wind wi where w.city=:pcity group by 1,2")

})
public class Weather {
	
	@Id
	private String weatherId;
	
	private String city;
	private String description;
	private String humidity;
	private String pressure;
	private String temperature;
	private Date timestamp;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="windId")
	private Wind wind;
	
	@Transient
	private String formatter;
	
	public Weather(){
		this.weatherId = UUID.randomUUID().toString();
		this.formatter = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	}
	
	public Weather(String formatter) {
		this.weatherId = UUID.randomUUID().toString();
		this.formatter = formatter;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHumidity() {
		return humidity;
	}
	
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	public String getPressure() {
		return pressure;
	}
	
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	
	public String getTemperature() {
		return temperature;
	}
	
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String getTimestamp() {
		return timestamp.toLocaleString();
	}
	
	public void setTimestamp(String timestamp) {
		SimpleDateFormat date = new SimpleDateFormat(this.formatter);

		try {
			this.timestamp = date.parse(timestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Wind getWind() {
		return wind;
	}
	
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "Weather [weatherId=" + weatherId + ", city=" + city + ", description=" + description + ", humidity="
				+ humidity + ", pressure=" + pressure + ", temperature=" + temperature + ", timestamp=" + timestamp
				+ ", wind=" + wind + ", formatter=" + formatter + "]";
	}
	
	

}
