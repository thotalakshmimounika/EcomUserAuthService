package dev.mounika.EcommUserAuthService.service;

import dev.mounika.EcommUserAuthService.dto.LoginRequestDTO;
import dev.mounika.EcommUserAuthService.dto.SignUpRequestDTO;
import dev.mounika.EcommUserAuthService.dto.UserResponseDTO;
import dev.mounika.EcommUserAuthService.entity.Role;
import dev.mounika.EcommUserAuthService.entity.User;
import dev.mounika.EcommUserAuthService.exception.InvalidCrdentialsException;
import dev.mounika.EcommUserAuthService.exception.RoleNotFoundException;
import dev.mounika.EcommUserAuthService.exception.UserNotFoundException;
import dev.mounika.EcommUserAuthService.respository.RoleRepository;
import dev.mounika.EcommUserAuthService.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

   @Autowired
    private UserRepository userRepository;
   @Autowired
   private RoleRepository roleRepository;



    @Override
    public UserResponseDTO signup(SignUpRequestDTO signUpRequestDTO) throws RoleNotFoundException {
        Role role = roleRepository.findById(signUpRequestDTO.getRoleId()).orElseThrow(
                () -> new RoleNotFoundException("Role not found")
        );

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername(signUpRequestDTO.getUsername());
        user.setPassword(encoder.encode(signUpRequestDTO.getPassword()));
        user.setEmailId(signUpRequestDTO.getEmail());
        user.setRoles(List.of(role));
        return UserResponseDTO.from(userRepository.save(user));

    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
       BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User savedUser = userRepository.findByEmailId(loginRequestDTO.getEmail()).orElseThrow(
                () -> new UserNotFoundException("Role not found")
        );
        if(bCryptPasswordEncoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword())) {
            String UserData = savedUser.getEmailId() + savedUser.getPassword() + LocalDateTime.now();
            String token = bCryptPasswordEncoder.encode(UserData);
            savedUser.setToken(token);
        }
        else{
            throw new InvalidCrdentialsException("Credentials mismatch");
        }
        savedUser = userRepository.save(savedUser);
        return UserResponseDTO.from(savedUser);
    }

    @Override
    public boolean validateToken(String token) {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                ()-> new InvalidCrdentialsException("Token is not valid")
        );
        return true;
    }

    @Override
    public boolean logout(String token) {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCrdentialsException("Token is not valid")
        );
        savedUser.setToken(null);
        userRepository.save(savedUser);
        return true;
    }
}
