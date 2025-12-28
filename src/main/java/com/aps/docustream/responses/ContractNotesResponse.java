package com.aps.docustream.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractNotesResponse extends DocustreamResponse{

	private static final long serialVersionUID = -8657751824185846485L;
	
	public ContractNotesResponse(String documentId, String documentName, String documentStatus, String message) {
		super(documentId, documentName, documentStatus, message);
		// TODO Auto-generated constructor stub
	}

}
