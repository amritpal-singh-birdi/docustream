package com.aps.docustream.kafka.processor;

import org.springframework.stereotype.Component;

import com.aps.docustream.entities.DocumentEntity;
import com.aps.docustream.renderer.DocumentRendererFactory;
import com.aps.docustream.repository.DocustreamRepository;
import com.aps.docustream.service.PdfGenerationService;

@Component
public class DocumentProcessorFactory {

	private final DocustreamRepository repository;
	private final PdfGenerationService pdfGenerationService;
	private final DocumentRendererFactory rendererFactory;

	public DocumentProcessorFactory(DocustreamRepository repository, PdfGenerationService pdfGenerationService, DocumentRendererFactory rendererFactory) {
		this.repository = repository;
		this.pdfGenerationService = pdfGenerationService;
		this.rendererFactory = rendererFactory;
	}
	
	public DocumentProcessor getProcessor(String documentId, DocustreamRepository repository, PdfGenerationService pdfGenerationService) throws IllegalAccessException {
		DocumentEntity entity = repository.findByDocumentId(documentId);

		switch (entity.getDocumentType()) {
		case CONTRACT_NOTE:
			return new ContractNoteProcessor(repository, pdfGenerationService);
		case RESUME:
			return new ResumeProcessor();
		case INVOICE:
			return new InvoiceProcessor(repository, pdfGenerationService, rendererFactory);
		default:
			return new RawDocumentProcessor();
		}
		
	}
	
}
