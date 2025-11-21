package uz.pdp.g57jakarta_ee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.g57jakarta_ee.model.Todo;
import uz.pdp.g57jakarta_ee.service.TodoService;

import java.io.IOException;
import java.util.List;

@WebServlet({"/todo", "/"})
public class TodoServlet extends HttpServlet {
    private TodoService service = new TodoService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String userId = session.getAttribute("userId").toString();

        String action = request.getParameter("action");
        if ("create".equals(action))
            service.create(request, userId);
        else if ("delete".equals(action))
            service.delete(request);
        else if ("update".equals(action))
            service.update(request);

        response.sendRedirect("/todo");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = session.getAttribute("userId").toString();
        List<Todo> todos = service.getAll(userId);
        String action = req.getParameter("action");
        if ("update".equals(action)) {
            String todoId = req.getParameter("id");
            Todo todo = service.get(todoId);
            session.setAttribute("todo", todo);
            resp.sendRedirect("/update.jsp");
        } else {
            session.setAttribute("todos", todos);
//            resp.sendRedirect("/home.jsp");

            req.setAttribute("todos", todos);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }


    }
}


// Java server page

// scriptlets -> [scriptlet, expressions, declarations]
// <% %> -> scriptlet
// <%= %> -> expressions
// <%! %> -> declarations


// request, session, application

// authentication -> userni tanish jarayoni
// authorization  -> userni huquqlarini tekshirish jarayoni