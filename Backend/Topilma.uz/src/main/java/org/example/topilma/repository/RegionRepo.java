package org.example.topilma.repository;

import org.example.topilma.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegionRepo extends JpaRepository<Region, UUID> {
}
