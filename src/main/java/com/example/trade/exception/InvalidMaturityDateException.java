package com.example.trade.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidMaturityDateException extends RuntimeException {

	public InvalidMaturityDateException(String message) {
		super(message);
	}

	public InvalidMaturityDateException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
