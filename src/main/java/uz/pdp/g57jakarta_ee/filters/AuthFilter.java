package uz.pdp.g57jakarta_ee.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebFilter("/*")
public class AuthFilter extends HttpFilter {

    private final List<String> PUBLIC_PATHS = List.of(
            "/login",
            "/login.jsp",
            "/public"
    );

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String path = req.getRequestURI();
        boolean sessionUserAuthenticated = req.getSession().getAttribute("userId") != null;
        boolean currentPathIsPrivate = !isPublic(path);

        if (currentPathIsPrivate && !sessionUserAuthenticated) {
            res.sendRedirect("/login");
            return;
        }

        chain.doFilter(req, res);
    }

    public boolean isPublic(String url) {
        return PUBLIC_PATHS.contains(url);
    }
}
