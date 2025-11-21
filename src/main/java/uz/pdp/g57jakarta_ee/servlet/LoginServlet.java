package uz.pdp.g57jakarta_ee.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import uz.pdp.g57jakarta_ee.model.AuthUser;
import uz.pdp.g57jakarta_ee.model.Gender;
import uz.pdp.g57jakarta_ee.service.AuthUserService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AuthUserService authUserService = AuthUserService.getInstance();

    @Override
    public void init(ServletConfig config) throws ServletException {
//        authUserService.create("demo", "123", "Muhammadkomil", "https://thumbs.dreamstime.com/b/portrait-handsome-smiling-young-man-folded-arms-smiling-joyful-cheerful-men-crossed-hands-isolated-studio-shot-172869765.jpg", Gender.MALE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AuthUser authUser = authUserService.login(username, password);
        HttpSession session = req.getSession();
        session.setAttribute("userId", authUser.getId());
        resp.sendRedirect("/todo");
    }
}
