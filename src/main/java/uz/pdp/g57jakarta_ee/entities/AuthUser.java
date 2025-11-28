package uz.pdp.g57jakarta_ee.entities;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.g57jakarta_ee.UzbekNumber;

@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@DiscriminatorColumn(name = "user_type")
@Entity
@Table(name = "auth_user")
@ToString
public class AuthUser extends AuditableEntity {
    private String fullName;
    private String username;
    private String password;

    @UzbekNumber(message = "Bu ozbek raqami emas")
    private String phone;
}


// JOINED
// SINGLE_TABLE
// ALOHIDA_JADVAL
