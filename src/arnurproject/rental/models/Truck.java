package arnurproject.rental.models;

public class Truck extends Vehicle {
    private double liftingcapacity;
    // конструктоо
    public Truck(String brand, String model, int year, int pricePerDay, double liftingcapacity) {
        super(brand, model, year, pricePerDay);
        this.liftingcapacity = liftingcapacity;
    }
    // геттер
    public double getLiftingcapacity() {
        return liftingcapacity;
    }
    // сеттер
    public void setLiftingcapacity(double liftingcapacity) {
        this.liftingcapacity = liftingcapacity;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Lifting capacity: " + liftingcapacity;
    }
}