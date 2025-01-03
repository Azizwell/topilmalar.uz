package org.example.topilma.controller;

import lombok.RequiredArgsConstructor;
import org.example.topilma.dto.applicant.ApplicantDto;
import org.example.topilma.service.applicant.ApplicantService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicant")
@RequiredArgsConstructor
public class ApplicantController {

  final ApplicantService applicantService;


  @PostMapping
  public HttpEntity<?> postApplicant(@RequestBody ApplicantDto applicantDto) {
    return applicantService.postApplicant(applicantDto);
  }

  @GetMapping
  public HttpEntity<?> getEntityProjectionQuery(
          @RequestParam(required = false) String type,
          @RequestParam(required = false) String status,
          @RequestParam(required = false) String miniType,
          @RequestParam(required = false) String region,
          @RequestParam(required = false) String district,
          @RequestParam(required = false) String serialNumber) {

    // Логирование входных параметров
//    System.out.println(type + " " + status + " " + miniType + " " + region + " " + district + " " + serialNumber);

    // Переадресация вызова в сервис
    return applicantService.getEntityProjectionQuery(type, status, miniType, region, district, serialNumber);
  }

}
