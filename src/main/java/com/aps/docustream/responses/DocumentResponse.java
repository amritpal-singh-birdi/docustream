package com.aps.docustream.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentResponse extends DocustreamResponse {
	
	private static final long serialVersionUID = 6759660129595440968L;

	@JsonProperty
	private String documentId;
	
	@JsonProperty
	private String documentType;
	
	@JsonProperty
	private String documentGenerationDate;
	
	@JsonProperty
	private String message;

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentGenerationDate() {
		return documentGenerationDate;
	}

	public void setDocumentGenerationDate(String documentGenerationDate) {
		this.documentGenerationDate = documentGenerationDate;
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
		return "DocumentResponse [documentId=" + documentId + ", documentType=" + documentType
				+ ", documentGenerationDate=" + documentGenerationDate + ", message=" + message + "]";
	}
	
	

}
