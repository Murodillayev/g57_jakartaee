package uz.pdp.g57jakarta_ee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.g57jakarta_ee.model.AuthUser;
import uz.pdp.g57jakarta_ee.service.AuthUserService;

import java.io.IOException;


@WebServlet("/user/*")
public class AuthUserServlet extends HttpServlet {

    private final AuthUserService authUserService = AuthUserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getRequestURI().replace("/user/", "");
        AuthUser authUser = authUserService.get(userId);

        req.setAttribute("user", authUser);
        req.getRequestDispatcher("/user.jsp").forward(req, resp);

    }
}
