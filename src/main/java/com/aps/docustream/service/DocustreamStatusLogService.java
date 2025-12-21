package com.aps.docustream.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.aps.docustream.entities.DocumentStatusLogEntity;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.repository.DocustreamStatusLogRepository;

@Service
public class DocustreamStatusLogService {

	private DocustreamStatusLogRepository statusLogRepository;
	
	public DocustreamStatusLogService(DocustreamStatusLogRepository statusLogRepository) {
		this.statusLogRepository = statusLogRepository;
	}

	public DocumentStatusLogEntity saveStatusLog(String documentId, DocumentStatus documentStatus, LocalDateTime startTime, LocalDateTime endTime, String remarks) {
		DocumentStatusLogEntity entity = new DocumentStatusLogEntity();
		
		entity.setDocumentId(documentId);
		entity.setGenerationStatus(documentStatus);
		entity.setStartTime(startTime);
		entity.setEndTime(endTime);
		entity.setRemarks(remarks);
		
		return statusLogRepository.save(entity);
	}
	
}
