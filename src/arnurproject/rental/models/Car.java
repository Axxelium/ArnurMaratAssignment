package arnurproject.rental.models;

public class Car extends Vehicle {
    private int seats;
    // констурктор
    public Car(String brand, String model, int year, int pricePerDay, int seats) {
        super(brand, model, year, pricePerDay);
        this.seats = seats;
    }
    // геттер
    public int getSeats() {
        return seats;
    }
    // сеттер
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString() + ", Seats: " + seats;
    }
}
