package io.egen.weather_spring_rest.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wind {
	
	@Id
	@Column(name="windId")
	private String windId;
	
	private String speed;
	private String degree;
	
	public Wind(){
		this.windId = UUID.randomUUID().toString();
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Wind [windId=" + windId + ", speed=" + speed + ", degree=" + degree + "]";
	}
	
	

}
