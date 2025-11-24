package uz.pdp.g57jakarta_ee.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@DiscriminatorValue(value = "TEACHER")
public class Teacher extends AuthUser {
    private Double salary;
    private String subject;
    private String level;

    @ManyToMany(mappedBy = "teachers")
    private List<Group> groups;

}


