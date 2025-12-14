package arnurproject.rental;
    
public class Client {
    private String name;
    private String surname;
    private int number;
    private boolean RentingStatus = false;
    private int balance;

    public void setInfo(String name, String surname, int number, ) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.RentingStatus = Renting;
        this.balance = balance;
    }

    public void getName() { return name; }
    public void getSurname() { return surname; }
    public void getNumber() { return number; }
    public void getRentingStatus() { return RentingStatus; }

}
