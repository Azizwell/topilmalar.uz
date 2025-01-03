package org.example.topilma.service.region_district;

import lombok.RequiredArgsConstructor;
import org.example.topilma.repository.DistrictRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
  final DistrictRepo districtRepo;

  @Override
  public HttpEntity<?> getDistrict(UUID regionId) {
    return ResponseEntity.ok(districtRepo.findAllByRegionIdDistricts(regionId));
  }
}
