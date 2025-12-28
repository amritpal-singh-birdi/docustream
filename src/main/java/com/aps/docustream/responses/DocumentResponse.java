package com.aps.docustream.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentResponse extends DocustreamResponse {
	
	public DocumentResponse(String documentId, String documentName, String documentStatus, String message) {
		super(documentId, documentName, documentStatus, message);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 6759660129595440968L;	

}
