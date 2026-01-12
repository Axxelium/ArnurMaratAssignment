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

    // сортировка
    public void sortByPrice() {
        int n = availableCars.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // бабл сорт
                if (availableCars[j].getPricePerDay() > availableCars[j + 1].getPricePerDay()) {
                    Vehicle temp = availableCars[j];
                    availableCars[j] = availableCars[j + 1];
                    availableCars[j + 1] = temp;
                }
            }
        }
        System.out.println("--- Vehicles sorted by price (Low to High) ---");
    }

    // Фильтрация
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