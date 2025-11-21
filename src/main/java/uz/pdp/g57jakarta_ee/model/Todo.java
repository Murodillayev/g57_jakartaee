package uz.pdp.g57jakarta_ee.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    private String id = UUID.randomUUID().toString();

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser user;


    // relationship

    // 1X1, nX1, 1Xn, nXn

}
