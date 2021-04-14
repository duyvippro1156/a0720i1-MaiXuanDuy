package Models;

public class House extends Services{
    private String standardRoom;
    private String otherFacilities;
    private int floor;

    public House(String id, String name, double area, double price, int numberOfPeople, String typeRents, String standardRoom, String otherFacilities, int floor) {
        super(id, name, area, price, numberOfPeople, typeRents);
        this.standardRoom = standardRoom;
        this.otherFacilities = otherFacilities;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", floor=" + floor +
                "} " + super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
