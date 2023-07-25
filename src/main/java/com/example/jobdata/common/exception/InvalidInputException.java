package com.example.jobdata.common.exception;

import java.io.Serial;

public class InvalidInputException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -6078058635971976546L;

	public InvalidInputException(String message) {
		super(message);
	}

}
