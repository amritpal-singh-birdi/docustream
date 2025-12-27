package com.aps.docustream.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aps.docustream.entities.DocumentStatusLogEntity;
import com.aps.docustream.entities.enums.DocumentAuditStatus;

public interface DocustreamStatusLogRepository extends JpaRepository<DocumentStatusLogEntity, Long>{

	Optional<DocumentStatusLogEntity> findByDocumentIdAndGenerationStatus(String documentId, DocumentAuditStatus generationStatus);
	//DocumentStatusLogEntity endPreviousStatus(String documentId, DocumentStatus status, LocalDateTime now);

}
