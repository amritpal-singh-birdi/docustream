package com.aps.docustream.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceResponse extends DocustreamResponse{

	private static final long serialVersionUID = -8877851634962925753L;
	
	public InvoiceResponse(String documentId, String documentName, String documentStatus, String message) {
		super(documentId, documentName, documentStatus, message);
	}

}
