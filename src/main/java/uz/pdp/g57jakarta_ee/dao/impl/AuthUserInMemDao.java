package uz.pdp.g57jakarta_ee.dao.impl;

import uz.pdp.g57jakarta_ee.dao.AuthUserDao;
import uz.pdp.g57jakarta_ee.model.AuthUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthUserInMemDao implements AuthUserDao {

    private static AuthUserInMemDao instance;
    private final List<AuthUser> AUTH_USERS = new ArrayList<>();

    private AuthUserInMemDao() {
    }

    public static AuthUserInMemDao getInstance() {
        if (instance == null) {
            instance = new AuthUserInMemDao();
        }
        return instance;
    }

    @Override
    public Optional<AuthUser> findByUsername(String username) {
        return AUTH_USERS.stream()
                .filter(authUser -> authUser.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    @Override
    public AuthUser save(AuthUser authUser) {

        Optional<AuthUser> exists = findById(authUser.getId());
        if (exists.isPresent()) {
            deleteById(authUser.getId());
        }
        AUTH_USERS.add(authUser);
        return authUser;
    }

    private void deleteById(String id) {
        AUTH_USERS.removeIf(authUser -> authUser.getId().equals(id));
    }

    public Optional<AuthUser> findById(String id) {
        return AUTH_USERS.stream().filter(authUser -> authUser.getId().equals(id)).findFirst();
    }
}
