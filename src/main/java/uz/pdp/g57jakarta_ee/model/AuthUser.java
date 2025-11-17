package uz.pdp.g57jakarta_ee.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthUser {
    private String id;
    private String fullName;
    private String username;
    private String password;
    private String imgPath;
}
