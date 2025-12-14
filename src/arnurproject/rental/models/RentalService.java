package arnurproject.rental.models;
import arnurproject.rental.models.Vehicle;

public class RentalService {
    private String companyName;
    private Vehicle[] availableCars;
    private double totalRevenue;

    // Конструктор
    public RentalService(String companyName, Vehicle[] cars) {
        this.companyName = companyName;
        this.availableCars = cars;
        this.totalRevenue = 0;
    }

    // Вывод информации
    public void showAvailableCars() {
        System.out.println("=== Welcome to " + companyName + " ===");
        System.out.println("Available vehicles:");
        for (int i = 0; i < availableCars.length; i++) {

            availableCars[i].printInfo();
        }
    }
}