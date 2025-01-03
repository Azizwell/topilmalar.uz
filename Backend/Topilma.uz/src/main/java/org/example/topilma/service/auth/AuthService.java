package org.example.topilma.service.auth;

import org.example.topilma.dto.user.LoginUserDto;
import org.example.topilma.dto.user.UserDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
  ResponseEntity<?> registerUser(UserDto userDto);


  ResponseEntity<?> loginUser(LoginUserDto loginUserDto);
}
