package arnurproject.rental;

import arnurproject.rental.models.Car;
import arnurproject.rental.models.RentalService;
import arnurproject.rental.models.Truck;
import arnurproject.rental.models.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020, 15000, 5);
        Car car2 = new Car("Kia", "Rio", 2019, 10000, 5);
        Truck truck1 = new Truck("BMW", "", 2021, 35000, 5000.0);

        Vehicle[] garage = {truck1, car2, car1};
        RentalService service = new RentalService("ArnurRental", garage);

        // --- 2. ЗАПУСК ИНТЕРАКТИВНОГО МЕНЮ ---
        Scanner scanner = new Scanner(System.in); // Создаем сканер для чтения ввода
        boolean isRunning = true; // Флаг для работы цикла

        System.out.println("Welcome to Rental System Console!");

        // Цикл будет работать, пока isRunning == true
        while (isRunning) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Show all available vehicles");
            System.out.println("2. Sort vehicles by price (Low -> High)");
            System.out.println("3. Search vehicle by max budget");
            System.out.println("4. Rent a vehicle (Simulation)"); // Дополнительная опция
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Считываем число, которое ввел пользователь
            int choice = scanner.nextInt();

            // Выбор
            switch (choice) {
                case 1:
                    service.showAvailableCars();
                    break;
                case 2:
                    service.sortByPrice();
                    System.out.println("Done! List is sorted.");
                    break;
                case 3:
                    System.out.print("Enter your max budget (KZT): ");
                    int budget = scanner.nextInt(); // ввод цены
                    service.searchByMaxPrice(budget);
                    break;
                case 4:
                    // аренда
                    System.out.println("Enter vehicle index to rent (0 - " + (garage.length - 1) + "): ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < garage.length) {
                        if (!garage[index].getRentingStatus()) {
                            garage[index].setRentingStatus(true);
                            System.out.println("Success! You rented: " + garage[index].getBrand());
                        } else {
                            System.out.println("Sorry, this vehicle is already rented.");
                        }
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    isRunning = false; // стоп
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}