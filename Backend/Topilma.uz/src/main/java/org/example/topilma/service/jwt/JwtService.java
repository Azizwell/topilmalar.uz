package org.example.topilma.service.jwt;

import org.example.topilma.entity.User;

public interface JwtService {
  String generateJwtToken(User user);

  String extractJwtToken(String token);
}
