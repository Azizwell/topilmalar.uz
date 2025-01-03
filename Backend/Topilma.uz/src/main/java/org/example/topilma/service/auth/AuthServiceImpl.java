package org.example.topilma.service.auth;

import lombok.RequiredArgsConstructor;
import org.example.topilma.dto.user.LoginUserDto;
import org.example.topilma.dto.user.UserDto;
import org.example.topilma.entity.Role;
import org.example.topilma.entity.User;
import org.example.topilma.repository.RoleRepo;
import org.example.topilma.repository.UserRepo;
import org.example.topilma.service.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  final RoleRepo roleRepo;
  final UserRepo userRepo;
  final PasswordEncoder passwordEncoder;
  final AuthenticationManager authenticationManager;
  final JwtService jwtService;


  @Override
  public ResponseEntity<?> registerUser(UserDto userDto) {
    List<Role> roleUser = roleRepo.findAllByName("ROLE_USER");

    User user = User.builder().username(userDto.username()).firstName(userDto.firstName()).image(userDto.image())
            .password(passwordEncoder.encode(userDto.password()))
            .roles(roleUser)
            .isEnabled(true).build();
    userRepo.save(user);

    return ResponseEntity.ok("registered");
  }

  @Override
  public ResponseEntity<?> loginUser(LoginUserDto loginUserDto) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginUserDto.username(), loginUserDto.password())
    );

    User users = userRepo.findByUsername(loginUserDto.username()).orElseThrow();
    String jwtToken = jwtService.generateJwtToken(users);
    HashMap<String, String> map = new HashMap<>();
    map.put("accessToken", jwtToken);
    map.put("email", users.getUsername());
    map.put("image", users.getImage());

    return ResponseEntity.ok(map);
  }

}
