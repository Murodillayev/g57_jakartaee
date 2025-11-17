package uz.pdp.g57jakarta_ee.service;

import uz.pdp.g57jakarta_ee.dao.AuthUserDao;
import uz.pdp.g57jakarta_ee.dao.impl.AuthUserDaoImpl;
import uz.pdp.g57jakarta_ee.model.AuthUser;

import java.util.UUID;

public class AuthUserService {
    private static AuthUserService instance;
//    private AuthUserDao dao = AuthUserInMemDao.getInstance();
    private AuthUserDao dao = AuthUserDaoImpl.getInstance();

    private AuthUserService() {
    }

    public static AuthUserService getInstance() {
        if (instance == null) {
            instance = new AuthUserService();
        }
        return instance;
    }

    public AuthUser login(String username, String password) {
        AuthUser authUser = dao.findByUsername(username).orElseThrow(
                () -> new RuntimeException("Bad credentials!")
        );

        if (!password.equals(authUser.getPassword())) {
            throw new RuntimeException("Bad credentials!");
        }

        return authUser;
    }

    public void create(String username, String password, String fullName, String imgPath) {
        AuthUser authUser = AuthUser.builder()
                .fullName(fullName)
                .username(username.toLowerCase())
                .password(password)
                .imgPath(imgPath)
                .id(UUID.randomUUID().toString())
                .build();

        dao.save(authUser);

        System.out.println(authUser.getId());
    }

    public AuthUser get(String userId) {
        return dao.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found!")
        );
    }
}
