package model;

public class Motel {
    private int id;
    private String name_customer;
    private String phone_number;
    private String date_begin;
    private int payment;
    private String note;

    public Motel() {
    }

    public Motel(int id, String name_customer, String phone_number, String date_begin, int payment, String note) {
        this.id = id;
        this.name_customer = name_customer;
        this.phone_number = phone_number;
        this.date_begin = date_begin;
        this.payment = payment;
        this.note = note;
    }
    public Motel(String name_customer, String phone_number, String date_begin, int payment, String note) {
        this.name_customer = name_customer;
        this.phone_number = phone_number;
        this.date_begin = date_begin;
        this.payment = payment;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(String date_begin) {
        this.date_begin = date_begin;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
