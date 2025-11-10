package uz.pdp.g57jakarta_ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/hello", "/salom", "/assalom"})
public class MyFirstServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        PrintWriter writer = resp.getWriter();
        writer.println("""
                
                """);
    }





}


// API -> (request) UNIQUE NAME, REQUEST BODY(optional), REQUEST PARAM(optional), HEADER, METHOD     ->  <- RESPONSE, HEADER, STATUS