package com.aps.docustream.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class DocustreamResponse implements Serializable {
	
	private static final long serialVersionUID = -3238211770716434239L;

	@JsonProperty
	private String documentId;

	@JsonProperty
	private String documentName;
	
	@JsonProperty
	private String documentStatus;
	
	@JsonProperty
	private String message;

	public DocustreamResponse(String documentId, String documentName, String documentStatus, String message) {
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentStatus = documentStatus;
		this.message = message;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
