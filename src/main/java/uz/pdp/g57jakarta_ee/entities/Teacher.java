package uz.pdp.g57jakarta_ee.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Size(min = 3, max = 10)
    @NotBlank
    @Pattern(regexp = "^[A-Za-z]{3,}$")
    private String subject;


    private String level;

    @ManyToMany(mappedBy = "teachers")
    private List<Group> groups;

}


