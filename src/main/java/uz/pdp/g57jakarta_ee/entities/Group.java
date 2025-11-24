package uz.pdp.g57jakarta_ee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@DiscriminatorColumn(name = "user_type")
@Entity
@Table(name = "groups")
public class Group extends AuditableEntity {

    private String name;

    private String description;

    @OneToMany
    private List<Student> students;

    @ManyToMany
    @JoinTable(
            name = "group_teacher",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "techer_id")
    )
    private List<Teacher> teachers;


    // Group group (lazy); group.getTechers() -> InitLazyException
    // Group group (eager); group.getTechers() -> [teacger1,teacger2]

}
