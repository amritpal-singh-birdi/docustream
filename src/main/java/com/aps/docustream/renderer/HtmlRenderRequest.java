package com.aps.docustream.renderer;

import java.util.Arrays;

import com.aps.docustream.entities.enums.DocumentType;

public class HtmlRenderRequest {

	private String documentId;
	
	private byte[] payload;
	
	private DocumentType documentType;

	public HtmlRenderRequest(String documentId, byte[] payload, DocumentType documentType) {
		super();
		this.documentId = documentId;
		this.payload = payload;
		this.documentType = documentType;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	@Override
	public String toString() {
		return "HtmlRenderRequest [documentId=" + documentId + ", payload=" + Arrays.toString(payload)
				+ ", documentType=" + documentType + "]";
	}
	
	
}
