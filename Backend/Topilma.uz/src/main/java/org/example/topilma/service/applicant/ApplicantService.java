package org.example.topilma.service.applicant;

import org.example.topilma.dto.applicant.ApplicantDto;
import org.springframework.http.HttpEntity;

public interface ApplicantService {
  HttpEntity<?> postApplicant(ApplicantDto applicantDto);

  HttpEntity<?> getEntityProjectionQuery(String type, String status, String miniType, String region, String district, String serialNumber);

  HttpEntity<?> getCarouselInfo();

  HttpEntity<?> getSearch(String keyword);
}
