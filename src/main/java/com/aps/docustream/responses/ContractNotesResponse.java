package com.aps.docustream.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractNotesResponse extends DocustreamResponse{

	private static final long serialVersionUID = -8657751824185846485L;
	
	@JsonProperty
	private String documentId;

	@JsonProperty
	private String documentName;
	
	@JsonProperty
	private String documentStatus;
	
	@JsonProperty
	private String message;

	public ContractNotesResponse(String documentId, String documentName, String documentStatus, String message) {
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

	@Override
	public String toString() {
		return "ContractNotesResponse [documentId=" + documentId + ", documentName=" + documentName
				+ ", documentStatus=" + documentStatus + ", message=" + message + "]";
	}
	
	
}
