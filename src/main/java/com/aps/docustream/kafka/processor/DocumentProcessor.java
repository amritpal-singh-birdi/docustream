package com.aps.docustream.kafka.processor;

public interface DocumentProcessor {

	void process(String documentId);
}
