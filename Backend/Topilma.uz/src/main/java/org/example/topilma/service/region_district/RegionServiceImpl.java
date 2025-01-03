package org.example.topilma.service.region_district;

import lombok.RequiredArgsConstructor;
import org.example.topilma.repository.RegionRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
  final RegionRepo regionRepo;

  @Override
  public HttpEntity<?> getRegion() {
    return ResponseEntity.ok(regionRepo.findAll());
  }
}
