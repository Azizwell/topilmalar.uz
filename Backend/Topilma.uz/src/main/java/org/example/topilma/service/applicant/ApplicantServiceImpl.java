package org.example.topilma.service.applicant;

import lombok.RequiredArgsConstructor;
import org.example.topilma.dto.applicant.ApplicantDto;
import org.example.topilma.entity.Applicant;
import org.example.topilma.entity.District;
import org.example.topilma.entity.Region;
import org.example.topilma.projection.EntityProjection;
import org.example.topilma.repository.ApplicantRepo;
import org.example.topilma.repository.DistrictRepo;
import org.example.topilma.repository.RegionRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

  final ApplicantRepo applicantRepo;
  final RegionRepo regionRepo;
  final DistrictRepo districtRepo;

  @Override
  public HttpEntity<?> postApplicant(ApplicantDto applicantDto) {
    District district = districtRepo.findById(UUID.fromString(applicantDto.districtId())).orElseThrow();
    Region region = regionRepo.findById(UUID.fromString(applicantDto.regionId())).orElseThrow();
    Applicant save = applicantRepo.save(Applicant.builder().region(region)
            .district(district).address(applicantDto.address()).phone(applicantDto.phone())
            .email(applicantDto.email()).build());
    return ResponseEntity.ok(save.getId());
  }

  @Override
  public HttpEntity<?> getEntityProjectionQuery(String type, String status, String miniType, String region, String district, String serialNumber) {

    UUID miniTypeUUID = (miniType != null && !miniType.isEmpty()) ? UUID.fromString(miniType) : null;
    UUID regionUUID = (region != null && !region.isEmpty()) ? UUID.fromString(region) : null;
    UUID districtUUID = (district != null && !district.isEmpty()) ? UUID.fromString(district) : null;


    if (type != null || status != null || miniTypeUUID != null || regionUUID != null || districtUUID != null || serialNumber != null) {

      List<EntityProjection> entityProjectionQuery = applicantRepo.getEntityProjectionQuery(type, status, miniTypeUUID, regionUUID, districtUUID, serialNumber);
      return ResponseEntity.ok(entityProjectionQuery);
    }

    List<EntityProjection> allEntityProjectionQuery = applicantRepo.getAllEntityProjectionQuery();


    return ResponseEntity.ok(allEntityProjectionQuery);
  }

  @Override
  public HttpEntity<?> getCarouselInfo() {
    return ResponseEntity.ok(applicantRepo.getByCarouselInfo());
  }

  @Override
  public HttpEntity<?> getSearch(String keyword) {
    return ResponseEntity.ok(applicantRepo.universalSearch(keyword)) ;
  }
}
