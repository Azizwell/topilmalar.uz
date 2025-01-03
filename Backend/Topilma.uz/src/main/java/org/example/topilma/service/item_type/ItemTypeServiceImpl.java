package org.example.topilma.service.item_type;

import lombok.RequiredArgsConstructor;
import org.example.topilma.repository.ItemRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemTypeServiceImpl implements ItemTypeService {
  final ItemRepo itemRepo;

  @Override
  public HttpEntity<?> getItem() {
    return ResponseEntity.ok(itemRepo.findAll());
  }
}
