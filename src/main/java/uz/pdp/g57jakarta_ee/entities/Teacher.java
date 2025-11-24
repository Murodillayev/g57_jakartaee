package uz.pdp.g57jakarta_ee.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue(value = "TEACHER")
public class Teacher extends AuthUser {
    private Double salary;
    private String subject;
    private String level;

}


