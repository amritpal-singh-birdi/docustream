package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DocumentBody implements Serializable {
	
	private static final long serialVersionUID = -4932290759539405560L;
	
	@JsonProperty
	private String documentBodyStream;
	
	@JsonProperty
	@Schema(description = "", implementation = DocumentPayload.class)
	private DocumentPayload payload;
	
	public DocumentBody() {
		
	}
	
	public DocumentBody(String documentBodyStream, DocumentPayload payload) {
		this.documentBodyStream = documentBodyStream;
		this.payload = payload;
	}

	public String getDocumentBodyStream() {
		return documentBodyStream;
	}
	
	public void setDocumentBodyStream(String documentBodyStream) {
		this.documentBodyStream = documentBodyStream;
	}

	public DocumentPayload getPayload() {
		return payload;
	}
	public void setPayload(DocumentPayload payload) {
		this.payload = payload;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DocumentBody [documentBodyStream=" + documentBodyStream + ", payload=" + payload + "]";
	}
	

}
