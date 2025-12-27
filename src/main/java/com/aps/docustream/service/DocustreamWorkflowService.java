package com.aps.docustream.service;

import org.springframework.stereotype.Service;

import com.aps.docustream.entities.enums.DocumentAuditStatus;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.entities.enums.DocumentType;

import jakarta.transaction.Transactional;

@Service
public class DocustreamWorkflowService {

	private final DocustreamService docustreamService;
	
	private final DocustreamStatusLogService docustreamStatusLogService;

	
	
	public DocustreamWorkflowService(DocustreamService docustreamService,
			DocustreamStatusLogService dcustreamStatusLogService) {
		this.docustreamService = docustreamService;
		this.docustreamStatusLogService = dcustreamStatusLogService;
	}

	@Transactional
	public void initiate(String documentId, DocumentType documentType, byte[] payload) {
		

		docustreamService.saveDocument(documentId, documentType, "Raw Payload of Docyment Type " + documentType.toString() + " saved in database", DocumentStatus.RECEIVED, payload);
		
		docustreamStatusLogService.startAudit(documentId, DocumentAuditStatus.PAYLOAD_SAVED, "Raw Payload of Docyment Type " + documentType.toString() + " saved in database");
		
		
	}
	
	@Transactional
	public void transition(String documentId, DocumentStatus fromStatus, DocumentStatus toStatus, DocumentAuditStatus fromAuditStatus, DocumentAuditStatus toAuditStatus, String remarks) {
		
		
		docustreamStatusLogService.endStatus(documentId, fromAuditStatus);
		
		docustreamService.updateStatus(documentId, toStatus);
		
		docustreamStatusLogService.startStatus(documentId, toAuditStatus);
		
		//dcustreamStatusLogService.startStatus(documentId, newStatus, remarks);//TODO: 
		
		/*
		 * DocumentEntity documentEntity = new DocumentEntity(); DocumentStatusLogEntity
		 * logEntity = new DocumentStatusLogEntity();
		 * 
		 * documentEntity.setGenerationStatus(documentStatus);
		 * documentRepository.save(documentEntity);
		 * 
		 * logEntity.setDocumentId(documentId);
		 * logEntity.setGenerationStatus(documentStatus);
		 * logEntity.setStartTime(startTime); logEntity.setEndTime(endTime);
		 * logEntity.setRemarks(remarks); statusLogRepository.save(logEntity);
		 */
		
	}
	
}
