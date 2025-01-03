package org.example.topilma.repository;

import org.example.topilma.entity.Applicant;
import org.example.topilma.entity.DocumentRequestInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentRepo extends JpaRepository<DocumentRequestInformation, UUID> {
}
