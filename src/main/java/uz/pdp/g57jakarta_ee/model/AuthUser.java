package uz.pdp.g57jakarta_ee.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_user")
@NamedQueries({
        @NamedQuery(name = "User.find", query = "from AuthUser where username = :username")
})

//@NamedNativeQueries({
//        @NamedNativeQuery(name = "", query = "")
//})
public class AuthUser {
    @Id
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "img_path")
    private String imgPath;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Todo> todos;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // fetchType -> Lazy, Eager

}
