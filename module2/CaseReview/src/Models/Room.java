package Models;

public class Room extends Services {
    private ExtraService freeService;

    public Room(String id, String name, double area, double price, int numberOfPeople, String typeRents, ExtraService freeService) {
        super(id, name, area, price, numberOfPeople, typeRents);
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService=" + freeService +
                "} " + super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    public ExtraService getFreeService() {
        return freeService;
    }

    public void setFreeService(ExtraService freeService) {
        this.freeService = freeService;
    }
}
