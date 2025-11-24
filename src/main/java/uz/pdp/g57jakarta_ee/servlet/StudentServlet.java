package uz.pdp.g57jakarta_ee.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.g57jakarta_ee.entities.Student;
import uz.pdp.g57jakarta_ee.repository.StudentRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private final StudentRepository repository = new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("post") != null) {
            repository.create();
        }

        List<Student> students = repository.findAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("students.jsp").forward(req, resp);
    }


}

