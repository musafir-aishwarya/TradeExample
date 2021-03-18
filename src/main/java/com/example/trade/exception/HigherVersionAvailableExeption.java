package com.example.trade.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class HigherVersionAvailableExeption extends RuntimeException {

	public HigherVersionAvailableExeption(String message)
	{
		super(message);
	}
	
	public HigherVersionAvailableExeption(String message, Throwable throwable)
	{
		super(message,throwable);
	}
}
