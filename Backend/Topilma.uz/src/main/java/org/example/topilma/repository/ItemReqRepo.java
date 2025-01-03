package org.example.topilma.repository;

import org.example.topilma.entity.ItemRequestInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemReqRepo extends JpaRepository<ItemRequestInformation, UUID> {
}
