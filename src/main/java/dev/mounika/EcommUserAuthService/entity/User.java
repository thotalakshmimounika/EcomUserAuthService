package dev.mounika.EcommUserAuthService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "Ecom_User")
public class User extends BaseModel{
    private String username;
    private String password;
    private String emailId;
    private String token; //temporary
    @ManyToMany
    private List<Role> roles;

}
