package uz.pdp.g57jakarta_ee.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends AuthUser {
    private Double salary;
    private String subject;
    private String level;

}
