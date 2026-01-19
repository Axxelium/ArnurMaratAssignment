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
            System.out.println("1. [CREATE] Register new Client");
            System.out.println("2. [READ] Show all Clients");
            System.out.println("3. [UPDATE] Edit Client");
            System.out.println("4. [DELETE] Remove Client");
            System.out.println("0. Back to Main Menu");
            System.out.print("Admin choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // CREATE
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Surname: ");
                    String surname = scanner.next();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    int balance = scanner.nextInt();

                    Client newClient = new Client(name, surname, phone, balance);
                    dbManager.addClient(newClient);
                    break;

                case 2:
                    // READ
                    System.out.println("\n--- List of Clients from DB ---");
                    ArrayList<Client> dbClients = dbManager.getAllClients();
                    for (Client c : dbClients) {
                        System.out.print("[ID: " + c.getId() + "] ");
                        c.printInfoClient();
                    }
                    break;

                case 3:
                    // UPDATE
                    System.out.print("Enter Client ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter NEW Phone Number: ");
                    String newPhone = scanner.next();
                    System.out.print("Enter NEW Balance: ");
                    int newBalance = scanner.nextInt();

                    dbManager.updateClient(updateId, newPhone, newBalance);
                    break;

                case 4:
                    // DELETE
                    System.out.print("Enter Client ID to delete: ");
                    int deleteId = scanner.nextInt();

                    // Предупреждение
                    System.out.print("Are you sure? (1 - Yes, 0 - No): ");
                    int confirm = scanner.nextInt();
                    if (confirm == 1) {
                        dbManager.deleteClient(deleteId);
                    } else {
                        System.out.println("Operation cancelled.");
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