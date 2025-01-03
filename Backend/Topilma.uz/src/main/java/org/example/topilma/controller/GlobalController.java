package org.example.topilma.controller;

import lombok.RequiredArgsConstructor;
import org.example.topilma.entity.DocumentRequestInformation;
import org.example.topilma.entity.ItemRequestInformation;
import org.example.topilma.repository.ApplicantRepo;
import org.example.topilma.repository.DocumentRepo;
import org.example.topilma.repository.ItemReqRepo;
import org.example.topilma.service.applicant.ApplicantService;
import org.example.topilma.service.document.DocumentService;
import org.example.topilma.service.item_type.ItemTypeService;
import org.example.topilma.service.market.MarketService;
import org.example.topilma.service.region_district.DistrictService;
import org.example.topilma.service.region_district.RegionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GlobalController {

  final RegionService regionService;
  final DistrictService districtService;
  final MarketService marketService;
  final ItemTypeService itemTypeService;
  final DocumentService documentService;
  final DocumentRepo documentRepo;
  final ItemReqRepo itemReqRepo;
  final ApplicantService applicantService;
  final ApplicantRepo applicantRepo;

  @GetMapping("/region")
  public HttpEntity<?> getRegion() {
    return regionService.getRegion();
  }

  @GetMapping("/district")
  public HttpEntity<?> getDistrict(@RequestParam UUID regionId) {
    System.out.println(regionId);
    return districtService.getDistrict(regionId);
  }

  @GetMapping("/market")
  public HttpEntity<?> getMarket() {
    return marketService.getMarket();
  }

  @GetMapping("/item")
  public HttpEntity<?> getItem() {
    return itemTypeService.getItem();
  }

  @PatchMapping("/reestr")
  public ResponseEntity<?> getReestr(@RequestParam(required = false) UUID reestrId) {

    Optional<DocumentRequestInformation> optionalDoc = documentRepo.findById(reestrId);
    Optional<ItemRequestInformation> optionalItem = itemReqRepo.findById(reestrId);


    System.out.println(optionalDoc);
    System.out.println(optionalItem);

    if (optionalItem.isPresent()) {
      return ResponseEntity.ok(optionalItem.get());
    }

    if (optionalDoc.isPresent()) {
      return ResponseEntity.ok(optionalDoc.get());
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Object not found in both repositories");
  }

  @GetMapping("/carousel")
  public HttpEntity<?> getCarouselInfo() {
    return applicantService.getCarouselInfo();
  }

  @GetMapping("/search")
  public HttpEntity<?> getSearch(@RequestParam String keyword) {
    return applicantService.getSearch(keyword);
  }

  @GetMapping("/region_stat")
  public HttpEntity<?> getRegionStat() {
    return ResponseEntity.ok(applicantRepo.getRegionStatistic());
  }

  @GetMapping("/statistic")
  public HttpEntity<?> getStatistic() {
    return ResponseEntity.ok(applicantRepo.getStatisticCount());
  }


}
