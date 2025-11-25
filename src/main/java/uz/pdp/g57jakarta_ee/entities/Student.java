package uz.pdp.g57jakarta_ee.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@DiscriminatorValue(value = "STUDENT")
public class Student extends AuthUser {
    private Double grade;
    private String groupId;

    @JoinColumn(name = "course_number")
    private Integer courseNumber;

    @ManyToOne
    private Group group;
}


// @Inheritance