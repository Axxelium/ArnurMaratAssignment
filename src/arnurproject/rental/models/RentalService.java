package arnurproject.rental.models;
import arnurproject.rental.models.Vehicle;
import arnurproject.rental.models.Client;

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

    // фильтрация
    public void searchByMaxPrice(int maxPrice) {
        System.out.println("--- Search Results (Cheaper than " + maxPrice + ") ---");
        boolean found = false;
        for (Vehicle v : availableCars) {
            if (v.getPricePerDay() <= maxPrice) {
                System.out.println(v.toString()); // Тут работает полиморфизм!
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found in this price range.");
        }
    }

    public void showAvailableCars() {
        System.out.println("=== " + companyName + " Garage ===");
        for (Vehicle vehicle : availableCars) {
            if (!vehicle.getRentingStatus()) {
                System.out.println(vehicle.toString());
            }
        }
    }
}