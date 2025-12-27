package com.aps.docustream.entities.enums;

public enum DocumentAuditStatus {

	PAYLOAD_SAVED,
	PAYLOAD_VALIDATED,
	KAFKA_PUBLISHED,
	KAFKA_CONSUMED,
	DOCUMENT_GENERATION,
	PDF_GENERATED
}
