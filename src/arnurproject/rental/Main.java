package arnurproject.rental;

import arnurproject.rental.data.DBManager;
import arnurproject.rental.models.Car;
import arnurproject.rental.models.Client;
import arnurproject.rental.models.RentalService;
import arnurproject.rental.models.Truck;
import arnurproject.rental.models.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static DBManager dbManager = new DBManager();

    public static void main(String[] args) {
        System.out.println("=== VEHICLE RENTAL SYSTEM ===");
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- LOGIN MENU ---");
            System.out.println("1. Login as ADMIN");
            System.out.println("2. Login as CLIENT");
            System.out.println("0. Exit");
            System.out.print("Select role: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runAdminMode(); // админ вход
                    break;
                case 2:
                    // клиент вход, потом болад
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void runAdminMode() {
        boolean isAdmin = true;
        while (isAdmin) {
            System.out.println("\n--- ADMIN PANEL (PostgreSQL) ---");
            System.out.println("1. [CREATE] Register new Client into DB");
            System.out.println("2. [READ] Show all Clients from DB");
            System.out.println("0. Back to Main Menu");
            System.out.print("Admin choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Добавление клиента
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Surname: ");
                    String surname = scanner.next();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    int balance = scanner.nextInt();

                    // Создание и добавление объекта в БД
                    Client newClient = new Client(name, surname, phone, balance);
                    dbManager.addClient(newClient);
                    break;

                case 2:
                    // Чтение списка из ДБ
                    System.out.println("\n--- List of Clients from DB ---");
                    ArrayList<Client> dbClients = dbManager.getAllClients();
                    for (Client c : dbClients) {
                        c.printInfoClient();
                    }
                    break;

                case 0:
                    isAdmin = false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}