package org.example.topilma.service.market;

import lombok.RequiredArgsConstructor;
import org.example.topilma.repository.MarketRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService {
  final MarketRepo marketRepo;

  @Override
  public HttpEntity<?> getMarket() {
    return ResponseEntity.ok(marketRepo.findAll());
  }
}
