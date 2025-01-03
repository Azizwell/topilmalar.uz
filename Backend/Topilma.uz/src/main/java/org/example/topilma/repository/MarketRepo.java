package org.example.topilma.repository;

import org.example.topilma.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarketRepo extends JpaRepository<Market, UUID> {
}
