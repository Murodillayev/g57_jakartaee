package uz.pdp.g57jakarta_ee.repository;

import uz.pdp.g57jakarta_ee.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    Todo save(Todo todo);

    void delete(Todo todo);

    Optional<Todo> findById(String id);

    List<Todo> findAllByUserId(String userId);

}
