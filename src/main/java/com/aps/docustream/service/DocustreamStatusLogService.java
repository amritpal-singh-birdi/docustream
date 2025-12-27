package com.aps.docustream.service;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.aps.docustream.entities.DocumentStatusLogEntity;
import com.aps.docustream.entities.enums.DocumentAuditStatus;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.repository.DocustreamStatusLogRepository;

@Service
public class DocustreamStatusLogService {

	private DocustreamStatusLogRepository repository;
	
	public DocustreamStatusLogService(DocustreamStatusLogRepository statusLogRepository) {
		this.repository = statusLogRepository;
	}

	public DocumentStatusLogEntity startAudit(String documentId, DocumentAuditStatus documentStatus, String remarks) {
		DocumentStatusLogEntity entity = new DocumentStatusLogEntity();
		
		entity.setDocumentId(documentId);
		entity.setGenerationStatus(documentStatus);
		entity.setStartTime(LocalDateTime.now());
		entity.setRemarks(remarks);
		
		return repository.save(entity);
	}
	
	public DocumentStatusLogEntity endStatus(String documentId, DocumentAuditStatus status) {
		DocumentStatusLogEntity entity = repository.findByDocumentIdAndGenerationStatus(documentId, status).orElseThrow(() -> new IllegalStateException("No active audit found for documentId= " + documentId + " with status= " + status));
		entity.setEndTime(LocalDateTime.now());
		//repository.endPreviousStatus(documentId, status, LocalDateTime.now());
		return repository.save(entity);
	}
	
	public DocumentStatusLogEntity startStatus(String documentId, DocumentAuditStatus status) {
		DocumentStatusLogEntity entity = new DocumentStatusLogEntity();
		
		entity.setDocumentId(documentId);
		entity.setGenerationStatus(status);
		entity.setStartTime(LocalDateTime.now());
		entity.setRemarks("Audit for Status: " + status + " started.");
		
		return repository.save(entity);
		
	}
	
}
