package uz.pdp.g57jakarta_ee.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/file/*")
@MultipartConfig
public class FileServlet extends HttpServlet {

    String ROOT = "/Users/macbookpro/Documents/pdp/g57jakarta_ee/src/main/resources/store";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("file");
        InputStream inputStream = file.getInputStream();
        Path path = Paths.get(ROOT, file.getSubmittedFileName());
//        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        Files.write(path, inputStream.readAllBytes());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileName = req.getRequestURI().replace("/file/", "");
        FileInputStream fileInputStream = new FileInputStream(Paths.get(ROOT, fileName).toString());
        resp.getOutputStream().write(fileInputStream.readAllBytes());
        resp.setContentType("application/octet-stream");

        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
    }
}
