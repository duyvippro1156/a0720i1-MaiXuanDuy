package Models;

public abstract class Services {
    private String id;
    private String name;
    private double area;
    private double price;
    private int numberOfPeople;
    private String typeRents;

    public Services(String id, String name, double area, double price, int numberOfPeople, String typeRents) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.typeRents = typeRents;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", numberOfPeople=" + numberOfPeople +
                ", typeRents='" + typeRents + '\'' +
                '}';
    }

    public abstract void showInfor();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTypeRents() {
        return typeRents;
    }

    public void setTypeRents(String typeRents) {
        this.typeRents = typeRents;
    }
}
