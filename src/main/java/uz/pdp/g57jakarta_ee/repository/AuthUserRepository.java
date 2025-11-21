package uz.pdp.g57jakarta_ee.repository;

import uz.pdp.g57jakarta_ee.model.AuthUser;

import java.util.Optional;

public interface AuthUserRepository {

    Optional<AuthUser> findByUsername(String username);

    AuthUser save(AuthUser authUser);

    Optional<AuthUser> findById(String id);
}
