package uz.pdp.g57jakarta_ee.entities;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends AuthUser {
    private Double grade;
    private String group;
    private Integer courseNumber;
}
