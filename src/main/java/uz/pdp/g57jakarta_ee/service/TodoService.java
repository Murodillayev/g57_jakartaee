package uz.pdp.g57jakarta_ee.service;

import jakarta.servlet.http.HttpServletRequest;
import uz.pdp.g57jakarta_ee.model.AuthUser;
import uz.pdp.g57jakarta_ee.model.Todo;
import uz.pdp.g57jakarta_ee.repository.AuthUserRepository;
import uz.pdp.g57jakarta_ee.repository.TodoRepository;
import uz.pdp.g57jakarta_ee.repository.impl.AuthUserRepositoryImpl;
import uz.pdp.g57jakarta_ee.repository.impl.TodoRepositoryImpl;

import java.util.List;

public class TodoService {
    private final TodoRepository repository = TodoRepositoryImpl.getInstance();
    private final AuthUserRepository authUserRepository = AuthUserRepositoryImpl.getInstance();


    public void create(HttpServletRequest request, String userId) {
        AuthUser authUser = authUserRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User with id " + userId + " not found")
        );

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setCompleted(false);
        todo.setUser(authUser);
        repository.save(todo);
    }

    public void delete(HttpServletRequest request) {
        String todoId = request.getParameter("id");
        Todo todo = repository.findById(todoId).orElseThrow();
        repository.delete(todo);
    }

    public void update(HttpServletRequest request) {
        String todoId = request.getParameter("id");
        Todo todo = get(todoId);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        todo.setTitle(title);
        todo.setDescription(description);
        repository.save(todo);
    }

    public Todo get(String todoId) {
        return repository.findById(todoId).orElseThrow(
                () -> new RuntimeException("Todo not found")
        );
    }

    public List<Todo> getAll(String userId) {
//        AuthUser authUser = authUserRepository.findById(userId).orElseThrow();
//        return authUser.getTodos();

        return repository.findAllByUserId(userId);
    }
}
