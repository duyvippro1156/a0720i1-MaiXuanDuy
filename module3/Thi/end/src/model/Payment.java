package model;

public class Payment {
    private int id;
    private String name_payment;

    public Payment() {
    }

    public Payment(int id, String name_payment) {
        this.id = id;
        this.name_payment = name_payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_payment() {
        return name_payment;
    }

    public void setName_payment(String name_payment) {
        this.name_payment = name_payment;
    }
}
