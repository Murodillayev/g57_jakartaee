package uz.pdp.g57jakarta_ee.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@DiscriminatorValue(v
// alue = "STUDENT")
public class Student extends AuthUser {


    @Max(100)
    @Positive
    private Double grade;

    private String groupId;

    @JoinColumn(name = "course_number")
    @Max(value = 4, message = "kurs raqami 4 dan katta bolishi mumkin emas")
    @Min(value = 1, message = "kurs raqami 1 dan kichik bolishi mumkin emas")
    private Integer courseNumber;

    @ManyToOne
    private Group group;
}


// @Inheritance