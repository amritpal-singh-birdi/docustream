package com.aps.docustream.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.aps.docustream.entities.enums.DocumentAuditStatus;
import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.kafka.processor.DocumentProcessor;
import com.aps.docustream.kafka.processor.DocumentProcessorFactory;
import com.aps.docustream.repository.DocustreamRepository;
import com.aps.docustream.service.DocustreamWorkflowService;
import com.aps.docustream.service.PdfGenerationService;

@Component
public class DocustreamEventConsumer {

	private final DocumentProcessorFactory processorFactory;
	private final DocustreamWorkflowService workflowService;
	private final DocustreamRepository repository;
	private final PdfGenerationService pdfGenerationService;
	
	public DocustreamEventConsumer(DocumentProcessorFactory processorFactory,
			DocustreamWorkflowService workflowService, DocustreamRepository repository, PdfGenerationService pdfGenerationService) {
		super();
		this.processorFactory = processorFactory;
		this.workflowService = workflowService;
		this.repository = repository;
		this.pdfGenerationService = pdfGenerationService;
	}
	
	@KafkaListener(
			topics = "${docustream.kafka.topic.document-processor}",
			containerFactory = "kafkaListenerContainerFactory"
			)
	public void consume(String documentId, Acknowledgment ack) {

		DocumentProcessor processor;
		try {
			processor = processorFactory.getProcessor(documentId, repository, pdfGenerationService);
			

			workflowService.transition(documentId, DocumentStatus.ACCEPTED, DocumentStatus.PROCESSING, DocumentAuditStatus.KAFKA_PUBLISHED, DocumentAuditStatus.KAFKA_CONSUMED, "Payload extracted for PDF generation.");
			
			processor.process(documentId);
			
			workflowService.transition(documentId, DocumentStatus.PROCESSING, DocumentStatus.PDF_CREATED, DocumentAuditStatus.KAFKA_CONSUMED, DocumentAuditStatus.PDF_GENERATED, "PDF generated sucessfully");
			
			ack.acknowledge();
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}
	
}
