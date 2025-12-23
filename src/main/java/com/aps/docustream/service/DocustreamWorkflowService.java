package com.aps.docustream.service;

import java.time.LocalDateTime;

import com.aps.docustream.entities.DocumentEntity;
import com.aps.docustream.entities.DocumentStatusLogEntity;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.repository.DocustreamRepository;
import com.aps.docustream.repository.DocustreamStatusLogRepository;

public class DocustreamWorkflowService {

	private final DocustreamRepository documentRepository;
	
	private final DocustreamStatusLogRepository statusLogRepository;

	public DocustreamWorkflowService(DocustreamRepository documentRepository,
			DocustreamStatusLogRepository statusLogRepository) {
		this.documentRepository = documentRepository;
		this.statusLogRepository = statusLogRepository;
	}
	
	public void transition(String documentId, DocumentStatus documentStatus, LocalDateTime startTime, LocalDateTime endTime, String remarks) {
		
		DocumentEntity documentEntity = new DocumentEntity();
		DocumentStatusLogEntity logEntity = new DocumentStatusLogEntity();
		
		documentEntity.setGenerationStatus(documentStatus);
		documentRepository.save(documentEntity);
		
		logEntity.setDocumentId(documentId);
		logEntity.setGenerationStatus(documentStatus);
		logEntity.setStartTime(startTime);
		logEntity.setEndTime(endTime);
		logEntity.setRemarks(remarks);
		statusLogRepository.save(logEntity);
		
		
	}
	
}
