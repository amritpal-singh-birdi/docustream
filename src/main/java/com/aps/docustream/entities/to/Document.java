package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document implements Serializable {

	private static final long serialVersionUID = -8231580382491189693L;
	@JsonProperty
	private DocumentBody documentBody;
	public DocumentBody getDocumentBody() {
		return documentBody;
	}
	public void setDocumentBody(DocumentBody documentBody) {
		this.documentBody = documentBody;
	}
	@Override
	public String toString() {
		return "Document [documentBody=" + documentBody + "]";
	}
	
	
}
