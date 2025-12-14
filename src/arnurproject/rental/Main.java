package arnurproject.rental;
import arnurproject.rental.models.Vehicle;
import arnurproject.rental.models.Client;
import arnurproject.rental.models.RentalService;

public class Main {
        public static void main(String[] args) {
            System.out.println("Начало");
            Vehicle car1 = new Vehicle("Toyota", "Camry", 2020, 15000);
            Vehicle car2 = new Vehicle("BMW", "X5", 2022, 35000);
            Vehicle car3 = new Vehicle("Kia", "Rio", 2019, 10000);

            Vehicle[] garage = {car1, car2, car3};

            RentalService myRentalCompany = new RentalService("Arnur AutoRental", garage);

            Client client1 = new Client("Aliya", "Nazarova", "+7 777 777 7777",false, 50000);

            myRentalCompany.showAvailableCars();


            System.out.println("\n--- Comparing Vehicles ---");
            if (car1.getPricePerDay() > car3.getPricePerDay()) {
                System.out.println(car1.getBrand() + " is more expensive than " + car3.getBrand());
            } else {
                System.out.println(car1.getBrand() + " is cheaper or equal to " + car3.getBrand());
            }

            // Аренда
            System.out.println("\nClient " + client1.getName() + " is renting " + car2.getBrand() + " " + car2.getModel());

            car2.setRentingStatus(true); // Теперь BMW занята
            client1.setStatusClient(true);    // Клиент теперь арендатор

            System.out.println("\n--- Updated State (After Rent) ---");
            myRentalCompany.showAvailableCars(); // BMW уходит из списка

            // Вывод информации о клиенте
            System.out.println("\n--- Client Info ---");
            client1.printInfoClient();
        }
}