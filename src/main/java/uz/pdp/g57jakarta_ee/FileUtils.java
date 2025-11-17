package uz.pdp.g57jakarta_ee;

import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUtils {

    private static String root = "/Users/macbookpro/Documents/pdp/g57jakarta_ee/src/main/resources/store";

    public static String uploadFile(Part image) {


        try {
            InputStream inputStream = image.getInputStream();
            String fileName = UUID.randomUUID() + "_" + image.getSubmittedFileName();
            Path path = Paths.get(root, fileName);
            Files.write(path, inputStream.readAllBytes());

            return "http://localhost:8080/file/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
