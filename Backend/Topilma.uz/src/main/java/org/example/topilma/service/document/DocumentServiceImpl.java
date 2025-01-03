package org.example.topilma.service.document;

import lombok.RequiredArgsConstructor;
import org.example.topilma.dto.document.DocumentDto;
import org.example.topilma.entity.*;
import org.example.topilma.repository.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
  final DocumentRepo documentRepo;
  final MarketRepo marketRepo;
  final RegionRepo regionRepo;
  final DistrictRepo districtRepo;
  final ApplicantRepo applicantRepo;

  @Override
  public HttpEntity<?> addDocuments(DocumentDto documentDto) {
    Applicant applicant = applicantRepo.findById(UUID.fromString(documentDto.applicantId())).orElseThrow();
    District district = districtRepo.findById(UUID.fromString(documentDto.lossDistrictId())).orElseThrow();
    Region region = regionRepo.findById(UUID.fromString(documentDto.givenRegionId())).orElseThrow();
    Market market = marketRepo.findById(UUID.fromString(documentDto.marketId())).orElseThrow();
    DocumentRequestInformation requestInformation = DocumentRequestInformation.builder().market(market).snp(documentDto.snp()).name(documentDto.name())
            .docContent(documentDto.docContent()).documentSerialNumber(documentDto.documentSerialNumber())
            .givenDate(documentDto.givenDate()).lossDate(documentDto.lossDate()).givenRegion(region)
            .lossDistrict(district).photo(documentDto.photo()).documentFile(documentDto.documentFile())
            .status(Status.valueOf(documentDto.status())).applicant(applicant).lossAddress(documentDto.lossAddress()).build();
    DocumentRequestInformation save = documentRepo.save(requestInformation);
    return ResponseEntity.ok(save);

  }
}
