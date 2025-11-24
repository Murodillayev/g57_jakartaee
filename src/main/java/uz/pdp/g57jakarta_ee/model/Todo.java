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
//@NamedQueries({
//        @NamedQuery(name = "Todo.user-todos", query = "from Todo t where t.user.id = :userId"),
//        @NamedQuery(name = "Todo.delete", query = "delete from Todo t where t.id = :id")
//})
@SqlResultSetMapping(
        name = "assda",
        entities = @EntityResult(entityClass = Todo.class)
)
@NamedNativeQueries({
        @NamedNativeQuery(name = "Todo.user-todos", query = """
                select t.* from todos t 
                    left join auth_user a on t.user_id = a.id 
                 where a.id = :userId
                 
                """,resultSetMapping = "assda"),
        @NamedNativeQuery(name = "Todo.delete", query = """
                delete from todo t where t.id = :id
                """)
})
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
