package com.aps.docustream.service;

import org.springframework.stereotype.Service;

import com.aps.docustream.entities.enums.DocumentAuditStatus;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.entities.to.Document;
import com.aps.docustream.entities.to.DocumentPayload;
import com.aps.docustream.entities.to.contractnote.ContractNote;
import com.aps.docustream.kafka.producer.DocustreamEventPublisher;
import com.aps.docustream.responses.ContractNotesResponse;
import com.aps.docustream.responses.DocustreamResponse;
import com.aps.docustream.responses.ErrorResponse;
import com.aps.docustream.responses.InvoiceResponse;
import com.aps.docustream.utils.Utilites;
import com.aps.docustream.wrapper.ContractNoteWrapper;
import com.aps.docustream.wrapper.InvoiceWrapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class DocustreamOrchestratorService {

	private final DocustreamService docustreamService;
	private final DocustreamWorkflowService workflowService;
	private final DocustreamEventPublisher publisher;
	public DocustreamOrchestratorService(DocustreamService docustreamService,
			DocustreamWorkflowService workflowService, DocustreamEventPublisher publisher) {
		this.docustreamService = docustreamService;
		this.workflowService = workflowService;
		this.publisher = publisher;
	}
	
	public DocustreamResponse orchestrateCreateDocument(PayloadType payloadType, Document document) {
		
		if(document.getDocumentBody() == null) {
			return new ErrorResponse(1111, "DocumentBody is empty", "DocumentBody is empty");
		}
		
		if(document.getDocumentBody().getDocumentBodyStream() != null && document.getDocumentBody().getPayload() != null) {
			throw new IllegalArgumentException("Both Raw payload and structed payload cannot be specified. Please share just one type of payload");
		}
		
		if(document.getDocumentBody().getDocumentBodyStream() != null) {
			//processRawPayload
		}else {
			//processStructuredPayload
			DocumentPayload payload = document.getDocumentBody().getPayload();
			String documentId = "";
			if(payload instanceof ContractNoteWrapper) {
				//processContractNote
				documentId = Utilites.generateDocumentId((ContractNoteWrapper) payload);
				//TODO: Once identified respective validations in the 
				//payload like validating anything specific to a particular payload content
				//Boolean process = processContractNote(payloadType, (ContractNoteWrapper) payload);
				
				ContractNoteWrapper contractNotePayload = (ContractNoteWrapper) payload;
				//if(process) {
					workflowService.initiate(documentId, payload.getDocumentType(), Utilites.serializePayload(payloadType,  contractNotePayload.getContractNote()));
				//}
				publisher.publishDocumentForProcessing(documentId);
				
				workflowService.transition(documentId, DocumentStatus.RECEIVED, DocumentStatus.ACCEPTED, DocumentAuditStatus.PAYLOAD_SAVED, DocumentAuditStatus.KAFKA_PUBLISHED, "Payload for Document Type: " + payload.getDocumentType() + " with Document ID: " + documentId + " published to Kafka");
				
				return new ContractNotesResponse(documentId, documentId + ".pdf", DocumentStatus.PROCESSING.toString(), "Document under processing");
				
			}else if(payload instanceof InvoiceWrapper) {
				documentId = Utilites.generateDocumentId((InvoiceWrapper) payload);
				
				InvoiceWrapper invoicePayload = (InvoiceWrapper) payload;
				workflowService.initiate(documentId, payload.getDocumentType(), Utilites.serializePayload(payloadType,  invoicePayload.getInvoice()));
				publisher.publishDocumentForProcessing(documentId);
				workflowService.transition(documentId, DocumentStatus.RECEIVED, DocumentStatus.ACCEPTED, DocumentAuditStatus.PAYLOAD_SAVED, DocumentAuditStatus.KAFKA_PUBLISHED, "Payload for Document Type: " + payload.getDocumentType() + " with Document ID: " + documentId + " published to Kafka");
				
				return new InvoiceResponse(documentId, documentId + ".pdf", DocumentStatus.PROCESSING.toString(), "Document under processing");
				
			}
			
			
			
			
		}
		 return new ErrorResponse(1111, "DocumentBody is empty", "DocumentBody is empty");
		
		
		//workflowService.transition("", DocumentStatus.RECEIVED, "Document is Received for Processing.");
	}
	
	
	private Boolean processContractNote(PayloadType type,  ContractNoteWrapper contractNoteWrapper) {
		
		
		
		Boolean validPayload = contractNoteWrapper.isValidPayload(contractNoteWrapper);
		//validatePayload
		
		//saveUsingDocustreamService
		
		return validPayload;
		
		
		
		
		
	}
	
	
}
