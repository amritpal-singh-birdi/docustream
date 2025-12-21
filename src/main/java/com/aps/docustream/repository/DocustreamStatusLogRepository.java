package com.aps.docustream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aps.docustream.entities.DocumentStatusLogEntity;

public interface DocustreamStatusLogRepository extends JpaRepository<DocumentStatusLogEntity, Long>{

}
