package uz.pdp.g57jakarta_ee.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private Boolean completed;
    private String userId;

}
