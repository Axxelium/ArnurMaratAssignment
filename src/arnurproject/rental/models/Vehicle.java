package arnurproject.rental;
    
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private int PricePerDay;

    public void setInfo(String brand, String model, int year, int PricePerDay) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.PricePerDay = PricePerDay;
    }

    public void getBrand() {
        return brand;
    }
    public void getModel() {
        return model;
    }
    public void getYear() {
        return year
    }
    public void getPrice() {
        return PricePerDay
    }
}
