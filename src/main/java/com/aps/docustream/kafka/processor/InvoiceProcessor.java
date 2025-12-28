package com.aps.docustream.kafka.processor;

import com.aps.docustream.entities.DocumentEntity;
import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.repository.DocustreamRepository;
import com.aps.docustream.service.PdfGenerationService;
import com.aps.docustream.validators.PayloadTypeDetector;

public class InvoiceProcessor implements DocumentProcessor {

	private final DocustreamRepository repository;
	private final PdfGenerationService pdfGenerationService;
	
	public InvoiceProcessor(DocustreamRepository repository, PdfGenerationService pdfGenerationService) {

		this.repository = repository;
		this.pdfGenerationService = pdfGenerationService;
	}

	@Override
	public void process(String documentId) {

		DocumentEntity entity = repository.findByDocumentId(documentId);
		
		byte[] payload = entity.getPayload();
		
		PayloadType payloadType = PayloadTypeDetector.checkAndValidatePayloadType(payload);
		
		byte[] pdfBytes = pdfGenerationService.generatePDF(payload, documentId, DocumentType.INVOICE, payloadType);
		
	}

}
