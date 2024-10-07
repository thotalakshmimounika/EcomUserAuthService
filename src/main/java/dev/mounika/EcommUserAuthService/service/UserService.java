package dev.mounika.EcommUserAuthService.service;

import dev.mounika.EcommUserAuthService.dto.LoginRequestDTO;
import dev.mounika.EcommUserAuthService.dto.SignUpRequestDTO;
import dev.mounika.EcommUserAuthService.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;


public interface UserService {
    UserResponseDTO signup(SignUpRequestDTO singUpRequestDTO) throws RoleNotFoundException;
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
    boolean logout(String token);
}
