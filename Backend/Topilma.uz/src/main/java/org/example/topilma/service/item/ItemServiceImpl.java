package org.example.topilma.service.item;

import lombok.RequiredArgsConstructor;
import org.example.topilma.dto.item.ItemDto;
import org.example.topilma.entity.*;
import org.example.topilma.repository.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
  final ItemRepo itemRepo;
  final RegionRepo regionRepo;
  final DistrictRepo districtRepo;
  final ApplicantRepo applicantRepo;
  final ItemReqRepo itemReqRepo;

  @Override
  public HttpEntity<?> addItemReqInfo(ItemDto itemDto) {
    Applicant applicant = applicantRepo.findById(UUID.fromString(itemDto.applicantId())).orElseThrow();
    District district = districtRepo.findById(UUID.fromString(itemDto.lossDistrictId())).orElseThrow();
    Region region = regionRepo.findById(UUID.fromString(itemDto.givenRegionId())).orElseThrow();
    Item item = itemRepo.findById(UUID.fromString(itemDto.itemId())).orElseThrow();
    ItemRequestInformation build = ItemRequestInformation.builder().item(item).name(itemDto.name()).itemSerialNumber(itemDto.itemSerialNumber())
            .color(itemDto.color()).shape(itemDto.shape()).weight(itemDto.weight()).givenDate(itemDto.givenDate())
            .lossDate(itemDto.lossDate()).givenRegion(region).lossDistrict(district).lossAddress(itemDto.lossAddress())
            .photo(itemDto.photo()).documentFile(itemDto.documentFile()).status(Status.valueOf(itemDto.status()))
            .applicant(applicant).code(itemDto.code()).build();
    ItemRequestInformation save = itemReqRepo.save(build);
    return ResponseEntity.ok(save);
  }
}
