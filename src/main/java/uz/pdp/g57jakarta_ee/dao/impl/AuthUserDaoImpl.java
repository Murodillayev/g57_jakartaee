package uz.pdp.g57jakarta_ee.dao.impl;

import uz.pdp.g57jakarta_ee.config.DbConfig;
import uz.pdp.g57jakarta_ee.dao.AuthUserDao;
import uz.pdp.g57jakarta_ee.model.AuthUser;

import java.sql.*;
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
        String query = "SELECT * FROM users WHERE username = ?;";

        try (Connection connection = DbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, uName);
            ResultSet resultSet = statement.executeQuery();
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
        String query = "insert into users(id,full_name,username,password) values (?,?,?,?)";
        try (Connection connection = DbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);) {
            statement.execute();

            return authUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<AuthUser> findById(String userId) {
        String query = "select * from users where id = ?";
        try (Connection connection = DbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
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
