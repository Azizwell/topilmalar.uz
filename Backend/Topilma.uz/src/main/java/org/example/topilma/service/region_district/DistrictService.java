package org.example.topilma.service.region_district;

import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface DistrictService {
  HttpEntity<?> getDistrict(UUID regionId);

}
