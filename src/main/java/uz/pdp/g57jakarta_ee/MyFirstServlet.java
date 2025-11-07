package uz.pdp.g57jakarta_ee;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");
//        writer.println("<h1>Salom Ahmadulloh!</h1>");
//        writer.println("<button>ok</button>");

        writer.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                
                <form>
                  <input type="text">
                </form>
                
                </body>
                </html>
               
                """);
    }

}
