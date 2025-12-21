package com.aps.docustream.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.aps.docustream.entities.DocumentEntity;
import com.aps.docustream.repository.DocustreamRepository;

@Service
public class DocustreamService {

	private DocustreamRepository repository;
	
	public DocustreamService(DocustreamRepository repository) {
		this.repository = repository;
	}



	public DocumentEntity saveDocument(String documentId, String documentType, String customerCode, byte[] payload) {
		DocumentEntity entity = new DocumentEntity();
		entity.setDocumentId(documentId);
		entity.setDocumentType(documentType);
		entity.setCustomerCode(customerCode);
		entity.setPayload(payload);
		entity.setCreationTimeStamp(LocalDateTime.now());
		return repository.save(entity);
	}
}
