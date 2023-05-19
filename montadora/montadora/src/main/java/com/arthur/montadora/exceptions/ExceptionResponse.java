package com.arthur.montadora.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date dateTime;
	private String message;
	private String details;
	
	public ExceptionResponse(Date dateTime, String message, String details) {
		super();
		this.dateTime = dateTime;
		this.message = message;
		this.details = details;
	}
	
	public ExceptionResponse() {
		
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
	
	
	

}
