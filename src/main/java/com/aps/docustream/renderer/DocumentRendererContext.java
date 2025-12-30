package com.aps.docustream.renderer;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.PayloadType;

public class DocumentRendererContext {

	private final String documentId;
	private final byte[] payloadBytes;
	private final PayloadType payloadType;
	private final DocumentType documentType;

	public DocumentRendererContext(String documentId, byte[] payloadBytes,
			PayloadType payloadType, DocumentType documentType) {
		super();
		this.documentId = documentId;
		this.payloadBytes = payloadBytes;
		this.payloadType = payloadType;
		this.documentType = documentType;
	}

	public String getDocumentId() {
		return documentId;
	}

	public byte[] getPayloadBytes() {
		return payloadBytes;
	}

	public PayloadType getPayloadType() {
		return payloadType;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}
	
}
