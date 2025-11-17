package uz.pdp.g57jakarta_ee.mapper;

import uz.pdp.g57jakarta_ee.model.Todo;

import java.sql.ResultSet;

public class UserMapper {
    public Todo fromResultSet(ResultSet resultSet) {
        try {
            String id = resultSet.getString("id");
            Boolean completed = resultSet.getBoolean("completed");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String user_id = resultSet.getString("user_id");
            return new Todo(id, title, description, completed, user_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
