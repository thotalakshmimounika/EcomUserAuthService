package dev.mounika.EcommUserAuthService.dto;

import dev.mounika.EcommUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO {
    private UUID roleId;
    private String role;
    private String description;

    public static RoleResponseDTO fromRole(Role role) {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setRole(role.getRolename());
        roleResponseDTO.setDescription(role.getDescription());
        return roleResponseDTO;
    }
}
