package com.malik.rest.webservices.restfulwebservices.Exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String meedage; 
	private String details;
	
	public ExceptionResponse(Date timestamp, String meedage, String details) {
		super();
		this.timestamp = timestamp;
		this.meedage = meedage;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getMeedage() {
		return meedage;
	}
	
	public void setMeedage(String meedage) {
		this.meedage = meedage;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
}
