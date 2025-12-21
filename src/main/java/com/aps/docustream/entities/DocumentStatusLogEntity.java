package com.aps.docustream.entities;

import java.time.LocalDateTime;

import com.aps.docustream.entities.enums.DocumentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_document_status_log")
public class DocumentStatusLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "document_id", nullable = false)
	private String documentId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "generation_status", nullable = false)
	private DocumentStatus generationStatus;
	
	@Column(name = "start_time", nullable = false)
	private LocalDateTime startTime;
	
	@Column(name = "end_time")
	private LocalDateTime endTime;
	
	@Column(name = "remarks")
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public DocumentStatus getGenerationStatus() {
		return generationStatus;
	}

	public void setGenerationStatus(DocumentStatus generationStatus) {
		this.generationStatus = generationStatus;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "DocumentStatusLogEntity [id=" + id + ", documentId=" + documentId + ", generationStatus="
				+ generationStatus + ", startTime=" + startTime + ", endTime=" + endTime + ", remarks=" + remarks + "]";
	}
	
	
	
}
