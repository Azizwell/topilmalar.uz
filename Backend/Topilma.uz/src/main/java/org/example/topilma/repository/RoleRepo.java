package org.example.topilma.repository;

import org.example.topilma.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, UUID> {
  List<Role> findAllByName(String name);

  @Query(value = "select * from role where name IN ('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'ROLE_OPERATOR')", nativeQuery = true)
  List<Role> findAdminRoles();

  @Query(value = "select id from role where name = :name ", nativeQuery = true)
  Long findByName(String name);
}
