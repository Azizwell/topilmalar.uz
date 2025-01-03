package org.example.topilma.repository;

import org.example.topilma.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DistrictRepo extends JpaRepository<District, UUID> {

  @Query(value = "select d.id, d.name from district d " +
          " join region_district rd on d.id = rd.district_id " +
          " join region r on rd.region_id = r.id " +
          " where r.id = :regionId " ,nativeQuery = true)
  List<District> findAllByRegionIdDistricts( UUID regionId );
}
