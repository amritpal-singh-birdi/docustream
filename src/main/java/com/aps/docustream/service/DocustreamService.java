package com.aps.docustream.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.aps.docustream.entities.DocumentEntity;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.repository.DocustreamRepository;

@Service
public class DocustreamService {

	private DocustreamRepository repository;
	private final DocustreamStatusLogService statusLogService;

	public DocustreamService(DocustreamRepository repository, DocustreamStatusLogService statusLogService) {
		this.repository = repository;
		this.statusLogService = statusLogService;
	}



	public DocumentEntity saveDocument(String documentId, String documentType, String customerCode, DocumentStatus documentStatus, byte[] payload) {
		DocumentEntity entity = new DocumentEntity();
		entity.setDocumentId(documentId);
		entity.setDocumentType(documentType);
		entity.setCustomerCode(customerCode);
		entity.setGenerationStatus(documentStatus);
		entity.setPayload(payload);
		entity.setCreationTimeStamp(LocalDateTime.now());
		
		DocumentEntity savedDoc = repository.save(entity);
		
		statusLogService.saveStatusLog(documentId, documentStatus, LocalDateTime.now(),null, customerCode);
		
		return savedDoc;
	}
	
	
}
