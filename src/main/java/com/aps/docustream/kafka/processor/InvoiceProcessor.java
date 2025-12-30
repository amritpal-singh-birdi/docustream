package com.aps.docustream.kafka.processor;

import com.aps.docustream.entities.DocumentEntity;
import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.renderer.DocumentRenderer;
import com.aps.docustream.renderer.DocumentRendererContext;
import com.aps.docustream.renderer.DocumentRendererFactory;
import com.aps.docustream.renderer.RenderedDocument;
import com.aps.docustream.repository.DocustreamRepository;
import com.aps.docustream.service.PdfGenerationService;
import com.aps.docustream.validators.PayloadTypeDetector;

public class InvoiceProcessor implements DocumentProcessor {

	private final DocustreamRepository repository;
	private final PdfGenerationService pdfGenerationService;
	private final DocumentRendererFactory rendererFactory;
	
	public InvoiceProcessor(DocustreamRepository repository, PdfGenerationService pdfGenerationService, DocumentRendererFactory rendererFactory) {

		this.repository = repository;
		this.pdfGenerationService = pdfGenerationService;
		this.rendererFactory = rendererFactory;
	}

	@Override
	public void process(String documentId) {

		DocumentEntity entity = repository.findByDocumentId(documentId);
		
		byte[] payload = entity.getPayload();
		
		PayloadType payloadType = PayloadTypeDetector.checkAndValidatePayloadType(payload);
		
		DocumentRenderer renderer = rendererFactory.getRenderer(entity.getRenderer());
		
		DocumentRendererContext context = new DocumentRendererContext(documentId, payload, payloadType, DocumentType.INVOICE);
		
		RenderedDocument document = renderer.render(context);
		//byte[] pdfBytes = pdfGenerationService.generatePDF(payload, documentId, DocumentType.INVOICE, payloadType);
		
	}

}
