package uz.pdp.g57jakarta_ee.dao.impl;

import uz.pdp.g57jakarta_ee.config.DbConfig;
import uz.pdp.g57jakarta_ee.dao.AuthUserDao;
import uz.pdp.g57jakarta_ee.model.AuthUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class AuthUserDaoImpl implements AuthUserDao {

    private static AuthUserDaoImpl instance;

    public static AuthUserDaoImpl getInstance() {
        if (instance == null) {
            instance = new AuthUserDaoImpl();
        }
        return instance;
    }

    @Override
    public Optional<AuthUser> findByUsername(String uName) {

        try (Connection connection = DbConfig.getConnection();
             Statement statement = connection.createStatement();) {

            String query = "SELECT * FROM users WHERE username = '%s'".formatted(uName);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String userId = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                AuthUser authUser = AuthUser.builder()
                        .id(userId)
                        .username(username)
                        .password(password)
                        .fullName(fullName)
                        .build();

                return Optional.of(authUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public AuthUser save(AuthUser authUser) {
        try (Connection connection = DbConfig.getConnection();
             Statement statement = connection.createStatement();) {
            String query = "insert into users(id,full_name,username,password) values ('%s','%s','%s','%s')".formatted(authUser.getId(), authUser.getFullName(), authUser.getUsername(), authUser.getPassword());
            statement.execute(query);

            return authUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<AuthUser> findById(String userId) {
        try (Connection connection = DbConfig.getConnection();
             Statement statement = connection.createStatement();) {
            String query = "select * from users where id = '%s'".formatted(userId);
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");

                AuthUser authUser = AuthUser.builder()
                        .id(userId)
                        .username(username)
                        .password(password)
                        .fullName(fullName)
                        .build();
                return Optional.of(authUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }
}
