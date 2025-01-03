package org.example.topilma.repository;

import org.example.topilma.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepo extends JpaRepository<Item, UUID> {
}
