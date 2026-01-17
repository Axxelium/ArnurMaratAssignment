package arnurproject.rental.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB {
    // Настройки
    private static final String URL = "jdbc:postgresql://localhost:5432/rental_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0000";

    // Соединение
    public static Connection getConnection() {
        try {
            // Подключение
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}