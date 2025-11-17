package uz.pdp.g57jakarta_ee.service;

import jakarta.servlet.http.HttpServletRequest;
import uz.pdp.g57jakarta_ee.dao.TodoDao;
import uz.pdp.g57jakarta_ee.dao.impl.TodoDaoImpl;
import uz.pdp.g57jakarta_ee.model.Todo;

import java.util.List;

public class TodoService {

//    private TodoDao dao = new TodoInMemDao();
    private TodoDao dao = new TodoDaoImpl();


    public void create(HttpServletRequest request, String userId) {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setCompleted(false);
        todo.setUserId(userId);
        dao.create(todo);
    }

    public void delete(HttpServletRequest request) {
        String todoId = request.getParameter("id");
        dao.delete(todoId);
    }

    public void update(HttpServletRequest request) {
        String todoId = request.getParameter("id");
        Todo todo = get(todoId);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        todo.setTitle(title);
        todo.setDescription(description);
        dao.update(todo);
    }

    public Todo get(String todoId) {
        return dao.findById(todoId).orElseThrow(
                () -> new RuntimeException("Todo not found")
        );
    }

    public List<Todo> getAll(String userId) {

        return dao.findAll(userId);
    }
}
