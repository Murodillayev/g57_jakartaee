package uz.pdp.g57jakarta_ee.dao.impl;

import uz.pdp.g57jakarta_ee.dao.TodoDao;
import uz.pdp.g57jakarta_ee.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoInMemDao implements TodoDao {

    private final List<Todo> todos = new ArrayList<>();

    @Override
    public void create(Todo todo) {
        todos.add(todo);
    }

    @Override
    public void delete(String todoId) {
        todos.removeIf(t -> t.getId().equals(todoId));
    }

    @Override
    public Optional<Todo> findById(String todoId) {
        return todos.stream().filter(t -> t.getId().equals(todoId)).findFirst();
    }

    @Override
    public void update(Todo todo) {
        delete(todo.getId());
        create(todo);
    }

    @Override
    public List<Todo> findAll(String userId) {

        return todos.stream().filter(t -> t.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
