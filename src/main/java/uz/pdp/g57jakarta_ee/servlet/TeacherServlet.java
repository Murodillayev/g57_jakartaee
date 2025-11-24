package uz.pdp.g57jakarta_ee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.g57jakarta_ee.entities.Student;
import uz.pdp.g57jakarta_ee.repository.StudentRepository;
import uz.pdp.g57jakarta_ee.repository.TeacherRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    private final StudentRepository repository = new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Student> all = repository.findAll();



    }
}
