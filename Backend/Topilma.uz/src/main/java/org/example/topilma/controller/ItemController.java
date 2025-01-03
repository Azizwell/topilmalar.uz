package org.example.topilma.controller;

import lombok.RequiredArgsConstructor;
import org.example.topilma.dto.document.DocumentDto;
import org.example.topilma.dto.item.ItemDto;
import org.example.topilma.service.document.DocumentService;
import org.example.topilma.service.item.ItemService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

  final ItemService itemService;


  @PostMapping
  public HttpEntity<?> addItemReqInfo(@RequestBody ItemDto itemDto) {
    return itemService.addItemReqInfo(itemDto);
  }

}
