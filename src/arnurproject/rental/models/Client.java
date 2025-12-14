package arnurproject.rental.models;
    
public class Client {
    private String name;
    private String surname;
    private int number;
    private boolean rentingStatus;
    private int balance;

    // Конструктор
    public Client(String name, String surname, int number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.rentingStatus = false;
        this.balance = 0;
    }

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
    public void setStatusClient(boolean rentingStatus) {
        this.rentingStatus = rentingStatus;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Геттеры
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getNumber() { return number; }
    public boolean getRentingStatusClient() { return rentingStatus; }
    public int getBalance() { return balance; }

    // Вывод информации
    public void printInfo() {
        System.out.println("Client name: " + name + " " + surname);
        System.out.println("Client number: " + number);
        System.out.println("Renting status: " + rentingStatus);
        System.out.println("Balance: " + balance);
        System.out.println("---------------------------");
    }
}
