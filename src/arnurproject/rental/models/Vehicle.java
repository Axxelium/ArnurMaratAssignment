package arnurproject.rental.models;
    
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private int pricePerDay;
    private boolean rentingStatus;

    // Конструктор
    public Vehicle(String brand, String model, int year, int pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.rentingStatus = false;
    }

    // Сеттеры
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public void setRentingStatus(boolean rentingStatus) {
        this.rentingStatus = rentingStatus;
    }

    // Геттеры
    public String getBrand() { return brand; }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public int getPrice() { return pricePerDay; }
    public boolean getRentingStatus() { return rentingStatus; }

    // Вывод информации
    public void printInfo() {
        System.out.println("Vehicle Info: " + brand + " " + model + " (" + year + ")");
        System.out.println("Daily Rate: " + pricePerDay + " KZT");
        System.out.println("Renting Status: " + rentingStatus);
        System.out.println("---------------------------");
    }
}
