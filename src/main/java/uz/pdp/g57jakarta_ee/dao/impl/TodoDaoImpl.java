package uz.pdp.g57jakarta_ee.dao.impl;

import org.postgresql.Driver;
import uz.pdp.g57jakarta_ee.config.DbConfig;
import uz.pdp.g57jakarta_ee.dao.TodoDao;
import uz.pdp.g57jakarta_ee.mapper.UserMapper;
import uz.pdp.g57jakarta_ee.model.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoDaoImpl implements TodoDao {

    private UserMapper mapper = new UserMapper();

    @Override
    public void create(Todo todo) {
        // PrepareStatement
        try (Connection connection = DbConfig.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO todos (id, title, description,user_id) VALUES ('%s','%s','%s','%s')".formatted(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getUserId());
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String todoId) {
        try (Connection connection = DbConfig.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM todos WHERE id = '" + todoId + "'";
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Todo> findById(String todoId) {

        try (Connection connection = DbConfig.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "select * from todos where id = '" + todoId + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Optional.of(mapper.fromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void update(Todo todo) {
        delete(todo.getId());
        create(todo);
    }

    @Override
    public List<Todo> findAll(String userId) {
        List<Todo> todos = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DbConfig.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "select * from todos where user_id = '%s'".formatted(userId);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Todo todo = mapper.fromResultSet(resultSet);
                todos.add(todo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return todos;
    }


}
