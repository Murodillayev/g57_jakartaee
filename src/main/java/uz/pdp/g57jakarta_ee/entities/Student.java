package uz.pdp.g57jakarta_ee.entities;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student extends AuthUser {
    private Double grade;
    private String groupId;
    @JoinColumn(name = "course_number")
    private Integer courseNumber;
}


// @Inheritance