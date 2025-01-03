package org.example.topilma.service.document;

import org.example.topilma.dto.document.DocumentDto;
import org.springframework.http.HttpEntity;

public interface DocumentService {
  HttpEntity<?> addDocuments(DocumentDto documentDto);

}
