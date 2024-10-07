package dev.mounika.EcommUserAuthService.entity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Ecom_Role")
public class Role extends BaseModel{
    private String rolename;
    private String description;
}
