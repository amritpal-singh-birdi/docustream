package com.aps.docustream.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.aps.docustream.entities.DocumentEntity;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.repository.DocustreamRepository;

@Service
public class DocustreamService {

	private DocustreamRepository repository;

	public DocustreamService(DocustreamRepository repository, DocustreamStatusLogService statusLogService) {
		this.repository = repository;
	}



	public DocumentEntity saveDocument(String documentId, DocumentType documentType, String customerCode, DocumentStatus documentStatus, byte[] payload) {
		DocumentEntity entity = new DocumentEntity();
		entity.setDocumentId(documentId);
		entity.setDocumentType(documentType);
		entity.setCustomerCode(customerCode);
		entity.setGenerationStatus(documentStatus);
		entity.setPayload(payload);
		entity.setCreationTimeStamp(LocalDateTime.now());
		entity.setModificationTimeStamp(LocalDateTime.now());
		
		DocumentEntity savedDoc = repository.save(entity);
		
		return savedDoc;
	}
	
	public DocumentEntity updateStatus(String documentId, DocumentStatus status) {
		DocumentEntity entity = repository.findByDocumentId(documentId);
		
		entity.setGenerationStatus(status);
		entity.setModificationTimeStamp(LocalDateTime.now());
		return repository.save(entity);
	}
	
}
