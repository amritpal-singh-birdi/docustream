package com.aps.docustream.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse extends DocustreamResponse{

	private static final long serialVersionUID = -710592192354156487L;

	@JsonProperty
	private Integer errorId;
	
	@JsonProperty
	private String errorDetails;
	
	@JsonProperty
	private String errorException;

	public ErrorResponse(Integer errorId, String errorDetails, String errorException) {
		super();
		this.errorId = errorId;
		this.errorDetails = errorDetails;
		this.errorException = errorException;
	}

	public Integer getErrorId() {
		return errorId;
	}

	public void setErrorId(Integer errorId) {
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
