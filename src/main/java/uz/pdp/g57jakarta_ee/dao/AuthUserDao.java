package uz.pdp.g57jakarta_ee.dao;


import uz.pdp.g57jakarta_ee.model.AuthUser;

import java.util.Optional;

public interface AuthUserDao {
    Optional<AuthUser> findByUsername(String username);


    AuthUser save(AuthUser authUser);

    Optional<AuthUser> findById(String userId);
}
