package uz.pdp.g57jakarta_ee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import uz.pdp.g57jakarta_ee.model.Gender;
import uz.pdp.g57jakarta_ee.utils.FileUtils;
import uz.pdp.g57jakarta_ee.service.AuthUserService;

import java.io.IOException;

@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

    private final AuthUserService authUserService = AuthUserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String gender = req.getParameter("gender");
        Part image = req.getPart("image");

        String imgPath = FileUtils.uploadFile(image);
        authUserService.create(username, password, fullName, imgPath, gender == null ? Gender.UNKNOWN : Gender.valueOf(gender.toUpperCase()));
        resp.sendRedirect("/login");

    }
}
