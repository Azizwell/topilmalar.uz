package org.example.topilma.repository;

import org.example.topilma.entity.Role;
import org.example.topilma.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
  Optional<User> findByUsername(String username);

  List<User> findAllByRoles(List<Role> roles);
}
