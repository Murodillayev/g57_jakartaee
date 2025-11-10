package uz.pdp.g57jakarta_ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String method = req.getMethod();

        if (method.equals("POST")) {
            Double a = Double.parseDouble(req.getParameter("a"));
            Double b = Double.parseDouble(req.getParameter("b"));
            String op = req.getParameter("operation");
            Double result = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> -1.;
            };

            writer.println("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Title</title>
                    </head>
                    <body>
                    
                    <h1>Result: %s</h1>
                    </html>
                    
                    """.formatted(result));
            return;
        }
        resp.setContentType("text/html");
        writer.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                
                <form action="/calc" method="post">
                    <input type="number" name="a">
                    <input type="text" name="operation">
                    <input type="number" name="b">
                    <button type="submit">Calc</button>
                </form>
                
                </body>
                </html>
                """);


    }
}
