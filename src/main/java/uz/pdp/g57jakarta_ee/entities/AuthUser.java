package uz.pdp.g57jakarta_ee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorColumn(name = "user_type")
@Entity
@Table(name = "auth_user")
public class AuthUser extends AuditableEntity {
    private String fullName;
    private String username;
    private String password;
    private String phone;

}
// JOINED
// SINGLE_TABLE
// ALOHIDA_JADVAL
