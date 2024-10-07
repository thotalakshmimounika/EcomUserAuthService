package dev.mounika.EcommUserAuthService.service;

import dev.mounika.EcommUserAuthService.dto.RoleRequestDTO;
import dev.mounika.EcommUserAuthService.dto.RoleResponseDTO;
import dev.mounika.EcommUserAuthService.entity.Role;
import dev.mounika.EcommUserAuthService.respository.RoleRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRolename(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        return RoleResponseDTO.fromRole(roleRepository.save(role));

    }
}
