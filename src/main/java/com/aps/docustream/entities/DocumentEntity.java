package com.aps.docustream.entities;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_documents")
public class DocumentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String documentId;
	
	private String documentType;
	
	private String customerCode;
	
	@Lob
	private byte[] payload;
	
	private String contentType;
	
	private String generationStatus;
	
	private LocalDateTime creationTimeStamp;
	
	private LocalDateTime modificationTimeStamp;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

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

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getGenerationStatus() {
		return generationStatus;
	}

	public void setGenerationStatus(String generationStatus) {
		this.generationStatus = generationStatus;
	}

	public LocalDateTime getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(LocalDateTime creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}

	public LocalDateTime getModificationTimeStamp() {
		return modificationTimeStamp;
	}

	public void setModificationTimeStamp(LocalDateTime modificationTimeStamp) {
		this.modificationTimeStamp = modificationTimeStamp;
	}

	@Override
	public String toString() {
		return "DocumentEntity [Id=" + Id + ", documentId=" + documentId + ", documentType=" + documentType
				+ ", customerCode=" + customerCode + ", payload=" + Arrays.toString(payload) + ", contentType="
				+ contentType + ", generationStatus=" + generationStatus + ", creationTimeStamp=" + creationTimeStamp
				+ ", modificationTimeStamp=" + modificationTimeStamp + "]";
	}
	
	
	
}
