package dev.mounika.EcommUserAuthService.dto;

import dev.mounika.EcommUserAuthService.entity.Role;
import dev.mounika.EcommUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class UserResponseDTO {
    private String username;
    private String email;
    private List<RoleResponseDTO> roles;
    private String token;

    public static UserResponseDTO from(User user) {
        if(user == null) return null;
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.username= user.getUsername();
        userResponseDTO.email = user.getEmailId();
        userResponseDTO.token = user.getToken();
        userResponseDTO.roles = new ArrayList<>();

        for(Role role : user.getRoles()) {
            RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
            roleResponseDTO.setRole(role.getRolename());
            roleResponseDTO.setDescription(role.getDescription());
            userResponseDTO.roles.add(roleResponseDTO);
        }
        return userResponseDTO;
    }
      //demo purpose , instead of creating separate mapper class for mapping all the attributes added in the DTO class itself
    public static User from(UserResponseDTO responseDTO) {
        return null;
    }
}
