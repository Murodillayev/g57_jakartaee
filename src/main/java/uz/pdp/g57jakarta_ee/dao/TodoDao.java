package uz.pdp.g57jakarta_ee.dao;

import uz.pdp.g57jakarta_ee.model.Todo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface TodoDao {

    void create(Todo todo);

    void delete(String todoId);

    Optional<Todo> findById(String todoId);

    void update(Todo todo);

    default List<Todo> findAll(String userId){
        return Collections.emptyList();
    }

}
