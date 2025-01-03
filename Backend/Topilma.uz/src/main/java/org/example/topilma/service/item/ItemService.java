package org.example.topilma.service.item;

import org.example.topilma.dto.item.ItemDto;
import org.springframework.http.HttpEntity;

public interface ItemService {
  HttpEntity<?> addItemReqInfo(ItemDto itemDto);
}
