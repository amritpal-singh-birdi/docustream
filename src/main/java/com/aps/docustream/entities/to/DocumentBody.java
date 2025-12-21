package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentBody implements Serializable {
	
	private static final long serialVersionUID = -4932290759539405560L;
	@JsonProperty
	private String documentBodyStream;
	
	@JsonProperty
	private ContractNote contractNote;
	
	
	
	
	
	public String getDocumentBodyStream() {
		return documentBodyStream;
	}
	public void setDocumentBodyStream(String documentBodyStream) {
		this.documentBodyStream = documentBodyStream;
	}
	
	public ContractNote getContractNote() {
		return contractNote;
	}
	public void setContractNote(ContractNote contractNote) {
		this.contractNote = contractNote;
	}
	
	
	@Override
	public String toString() {
		return "DocumentBody [documentBodyStream=" + documentBodyStream + ", contractNote=" + contractNote + "]";
	}
	

}
