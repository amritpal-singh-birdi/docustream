package com.aps.docustream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aps.docustream.entities.DocumentEntity;

public interface DocustreamRepository extends JpaRepository<DocumentEntity, Long>{

	DocumentEntity findByDocumentId(String documentId);
}
