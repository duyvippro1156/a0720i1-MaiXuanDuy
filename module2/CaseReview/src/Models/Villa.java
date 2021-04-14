package Models;

public class Villa extends Services {
    private String standardRoom;
    private double areaPool;
    private int floor;
    private String otherFacilities;

    public Villa(String id, String name, double area, double price, int numberOfPeople, String typeRents, String standardRoom, double areaPool, int floor, String otherFacilities) {
        super(id, name, area, price, numberOfPeople, typeRents);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.floor = floor;
        this.otherFacilities = otherFacilities;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", areaPool=" + areaPool +
                ", floor=" + floor +
                ", otherFacilities='" + otherFacilities + '\'' +
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }
}
