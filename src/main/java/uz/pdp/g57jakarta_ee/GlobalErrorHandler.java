package uz.pdp.g57jakarta_ee;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.SneakyThrows;

import javax.ws.rs.BadRequestException;
import java.io.IOException;
import java.util.StringJoiner;


@WebFilter("/*")
public class GlobalErrorHandler extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        try {
            chain.doFilter(req, res);

        } catch (ConstraintViolationException e) {
            handleConstraintViolationException(e, req, res);
        } catch (BadRequestException e) {

        } catch (Exception e) {
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @SneakyThrows
    private void handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest req, HttpServletResponse res) {

        String requestURI = req.getRequestURI();
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            stringJoiner.add(violation.getMessage());
        }

        req.setAttribute("error", stringJoiner.toString());
        req.getRequestDispatcher(requestURI).forward(req, res);
//        res.sendError(HttpServletResponse.SC_BAD_REQUEST, stringJoiner.toString());

    }
}
