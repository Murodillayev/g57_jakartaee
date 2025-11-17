package uz.pdp.g57jakarta_ee.dao.impl;

import lombok.NonNull;
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
        String sql = "INSERT INTO todos (id, title, description,user_id) VALUES (?,?,?,?)";
        // PrepareStatement
        try (Connection connection = DbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todo.getId());
            statement.setString(2, todo.getTitle());
            statement.setString(3, todo.getDescription());
            statement.setString(4, todo.getUserId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String todoId) {
        String sql = "DELETE FROM todos WHERE id = ?";
        try (Connection connection = DbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todoId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Todo> findById(String todoId) {
        String sql = "select * from todos where id = ?";

        try (Connection connection = DbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todoId);
            ResultSet resultSet = statement.executeQuery();
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
        String sql = "select * from todos where user_id = ?";
        try (Connection connection = DbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userId);

            ResultSet resultSet = statement.executeQuery();
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
