package dev.mounika.EcommUserAuthService.service;

import dev.mounika.EcommUserAuthService.dto.RoleRequestDTO;
import dev.mounika.EcommUserAuthService.dto.RoleResponseDTO;

public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
}
