package io.egen.weather_spring_rest.api.exception;

public class BadRequestException extends RuntimeException{
	
	public BadRequestException(String message)
	{
		super(message);
	}
	
	public BadRequestException(String message, Throwable cause)
	{
		super(message,cause);
	}

}


