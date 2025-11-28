package uz.pdp.g57jakarta_ee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;
import uz.pdp.g57jakarta_ee.entities.AuthUser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

@WebServlet("/test")
public class AuthUserServlet extends HttpServlet {

    private final AuthUserRepository repository = new AuthUserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        AuthUser authUser = new AuthUser();
        authUser.setPhone("+9989466512");
        authUser.setPassword("123");
        authUser.setUsername("admin");
        authUser.setCreatedAt(LocalDateTime.now());
        authUser.setUpdatedAt(LocalDateTime.now());
        Set<ConstraintViolation<AuthUser>> violations = validator.validate(authUser);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        } else {
            repository.create(authUser);
            resp.getWriter().println("<h1>%s</h1>".formatted(authUser));
        }


    }
}
