package uz.pdp.g57jakarta_ee.service;

import uz.pdp.g57jakarta_ee.model.AuthUser;
import uz.pdp.g57jakarta_ee.model.Gender;
import uz.pdp.g57jakarta_ee.repository.AuthUserRepository;
import uz.pdp.g57jakarta_ee.repository.impl.AuthUserRepositoryImpl;

import java.util.UUID;

public class AuthUserService {
    private static AuthUserService instance;
    private AuthUserRepository repository = AuthUserRepositoryImpl.getInstance();

    private AuthUserService() {
    }

    public static AuthUserService getInstance() {
        if (instance == null) {
            instance = new AuthUserService();
        }
        return instance;
    }

    public AuthUser login(String username, String password) {
        AuthUser authUser = repository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("Bad credentials!")
        );

        if (!password.equals(authUser.getPassword())) {
            throw new RuntimeException("Bad credentials!");
        }

        return authUser;
    }

    public void create(String username, String password, String fullName, String imgPath, Gender gender) {
        AuthUser authUser = AuthUser.builder()
                .fullName(fullName)
                .username(username.toLowerCase())
                .password(password)
                .imgPath(imgPath)
                .gender(gender)
                .id(UUID.randomUUID().toString())
                .build();

        repository.save(authUser);

    }

    public AuthUser get(String userId) {
        return repository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found!")
        );
    }
}
