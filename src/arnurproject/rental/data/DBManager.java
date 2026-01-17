package arnurproject.rental.data;

import arnurproject.rental.models.Client;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    // 1. CREATE добавление
    public void addClient(Client client) {
        String sql = "INSERT INTO clients (name, surname, phone_number, balance, renting_status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Заполнение
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getSurname());
            stmt.setString(3, client.getNumber()); // У тебя геттер getNumber() возвращает телефон
            stmt.setInt(4, client.getBalance());
            stmt.setBoolean(5, client.getRentingStatusClient());

            stmt.executeUpdate(); // Отправляем в БД
            System.out.println("Client added to Database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. READ Получение
    public ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";

        try (Connection conn = PostgresDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Читаем данные из строки таблицы
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone_number");
                int balance = rs.getInt("balance");

                // Создаем объект (используем твой конструктор)
                Client c = new Client(id ,name, surname, phone, balance);
                clients.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}