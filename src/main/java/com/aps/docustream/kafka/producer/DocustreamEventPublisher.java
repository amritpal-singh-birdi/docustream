package com.aps.docustream.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DocustreamEventPublisher {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${docustream.kafka.topic.document-processor}")
	private String documentProcessorTopic;

	public DocustreamEventPublisher(KafkaTemplate<String, String> kafkaTemplate, @Value("${docustream.kafka.topic.document-processor}") String documentProcessorTopic) {
		this.kafkaTemplate = kafkaTemplate;
		this.documentProcessorTopic = documentProcessorTopic;
	}

	public void publishDocumentForProcessing(String documentId) {
		kafkaTemplate.send(documentProcessorTopic, documentId);
	}
	
	
	
}
