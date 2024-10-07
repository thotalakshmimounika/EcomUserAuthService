package dev.mounika.EcommUserAuthService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter@Setter
public class SignUpRequestDTO {
    private String username;
    private String email;
    private String password;
    private UUID roleId;
}
