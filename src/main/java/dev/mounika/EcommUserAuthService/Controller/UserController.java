package dev.mounika.EcommUserAuthService.Controller;

import dev.mounika.EcommUserAuthService.dto.UserResponseDTO;
import dev.mounika.EcommUserAuthService.service.UserService;
import dev.mounika.EcommUserAuthService.dto.LoginRequestDTO;
import dev.mounika.EcommUserAuthService.dto.SignUpRequestDTO;
import dev.mounika.EcommUserAuthService.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
       return ResponseEntity.ok(userService.login(loginRequestDTO));

    }
    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorisation") String authToken) {
        return ResponseEntity.ok(userService.logout(authToken));

    }
    @PostMapping("/singup")
    public ResponseEntity<UserResponseDTO> singUp(@RequestBody SignUpRequestDTO singUpRequestDTO) throws RoleNotFoundException {
        return ResponseEntity.ok(userService.signup(singUpRequestDTO));

    }
    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader("Authorisation") String authToken){
        return ResponseEntity.ok(userService.validateToken(authToken));
    }

}
