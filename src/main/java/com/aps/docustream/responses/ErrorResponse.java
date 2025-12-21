package com.aps.docustream.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse implements Serializable{

	private static final long serialVersionUID = -710592192354156487L;

	@JsonProperty
	private String errorId;
	
	@JsonProperty
	private String errorDetails;
	
	@JsonProperty
	private String errorException;

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public String getErrorException() {
		return errorException;
	}

	public void setErrorException(String errorException) {
		this.errorException = errorException;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorId=" + errorId + ", errorDetails=" + errorDetails + ", errorException="
				+ errorException + "]";
	}
	
	
}
