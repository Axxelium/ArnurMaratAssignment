package arnurproject.rental.models;
    
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private int PricePerDay;

    // Сеттеры
    public void setInfo(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPricePerDay(int PricePerDay) {
        this.PricePerDay = PricePerDay;
    }

    // Геттеры
    public String getBrand() { return brand; }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public int getPrice() { return PricePerDay; }
}
