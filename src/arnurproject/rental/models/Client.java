package arnurproject.rental.models;
    
public class Client {
    private String name;
    private String surname;
    private int number;
    private boolean RentingStatus = false;
    private int balance;

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setName(boolean RentingStatus) {
        this.RentingStatus = RentingStatus;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Геттеры
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getNumber() { return number; }
    public boolean getRentingStatus() { return RentingStatus; }
    public int getBalance() { return balance; }

}
