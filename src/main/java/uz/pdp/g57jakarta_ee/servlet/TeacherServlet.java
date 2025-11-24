package uz.pdp.g57jakarta_ee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.g57jakarta_ee.entities.Teacher;
import uz.pdp.g57jakarta_ee.repository.TeacherRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    private final TeacherRepository repository = new TeacherRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers = repository.findAll();
        req.setAttribute("teachers", teachers);
        req.getRequestDispatcher("teachers.jsp").forward(req, resp);
    }
}
