package uz.pdp.g57jakarta_ee.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    public static Connection getConnection() {
        try {
//            Class.forName("org.postgresql.Driver");
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/todo",
                    "macbookpro",
                    "19801980"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
