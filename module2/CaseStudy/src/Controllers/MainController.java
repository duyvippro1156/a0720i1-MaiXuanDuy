package Controllers;

import Commons.*;
import models.*;
import java.util.*;

public class MainController {
    static Scanner input = new Scanner(System.in);
    static List<Customer> customerList = new ArrayList<>();

    static List<Services> villaList = new ArrayList<>();
    static List<Services> houseList = new ArrayList<>();
    static List<Services> roomList = new ArrayList<>();
    static List<Customer> bookingList = new ArrayList<>();

    static Set<String> nameVillaNotDuplicate = new TreeSet<>();
    static Set<String> nameHouseNotDuplicate = new TreeSet<>();
    static Set<String> nameRoomNotDuplicate = new TreeSet<>();

    static Map<String, Employee> employeeMap = new LinkedHashMap<>();

    public static void displayMainMenu() {
        System.out.println("---------- MAIN MENU ----------");
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information Of Employee");
        System.out.println("7. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {
                addNewServices();
                break;
            }
            case "2": {
                showServices();
                break;
            }
            case "3": {
                addNewCustomer();
                break;
            }
            case "4": {
                showCustomer();
                break;
            }
            case "5": {
                addNewBooking();
                break;
            }
            case "6": {
                showInformationOfEmployee();
                break;
            }
            case "7": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                input.nextLine();
                displayMainMenu();
            }
        }
    }

    public static void addNewServices() {
        System.out.println("---------- ADD NEW SERVICES ----------");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");
        System.out.println("-----------------------------------------");
        System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {
                addNewVilla();
                break;
            }
            case "2": {
                addNewHouse();
                break;
            }
            case "3": {
                addNewRoom();
                break;
            }
            case "4": {
                displayMainMenu();
                break;
            }
            case "5": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail!!! Please Choose again! Enter to continue.");
                input.nextLine();
                addNewServices();
            }
        }
    }

    public static void addNewVilla() {
        Villa villa = new Villa();

        String name;
        do {
            System.out.print("Name: ");
            name = input.nextLine();
        } while (!Validate.checkNameAndStandard(name));
        villa.setName(name);

        String checkID;
        do {
            System.out.print("ID: ");
            checkID = input.nextLine();
        } while (!Validate.checkIDVilla(checkID));
        villa.setId(checkID);

        String checkArea;
        do {
            System.out.print("Area: ");
            checkArea = input.nextLine();
        } while (!Validate.checkArea(checkArea));
        villa.setArea(checkArea);

        String amount;
        do {
            System.out.print("Amount: ");
            amount = input.nextLine();
        } while (!Validate.checkAmount(amount));
        villa.setAmount(amount);

        String checkPrice;
        do {
            System.out.print("Price: ");
            checkPrice = input.nextLine();
        } while (!Validate.checkPrice(checkPrice));
        villa.setPrice(checkPrice);

        String checkTypeRents;
        do {
            System.out.print("Type Rents: ");
            checkTypeRents = input.nextLine();
        } while (!Validate.checkTypeRent(checkTypeRents));
        villa.setTypeRents(checkTypeRents);

        String standard;
        do {
            System.out.print("Standard Room: ");
            standard = input.nextLine();
        } while (!Validate.checkNameAndStandard(standard));
        villa.setStandardRoom(standard);

        String checkAreaPool;
        do {
            System.out.print("Area Pool: ");
            checkAreaPool = input.nextLine();
        } while (!Validate.checkArea(checkAreaPool));
        villa.setAreaPool(checkAreaPool);

        String floor;
        do {
            System.out.print("Floor: ");
            floor = input.nextLine();
        } while (!Validate.checkFloor(floor));
        villa.setFloor(floor);

        String facilities;
        do {
            System.out.print("Other Facilities: ");
            facilities = input.nextLine();
        } while (!Validate.checkFacilities(facilities));
        villa.setOtherFacilities(facilities);

        villaList.add(villa);

        System.out.println("\nAdd new Villa completed!\n");
        FileCSV.writeServicesFileCSV(villaList, "villa");
        addNewServices();
    }

    public static void addNewHouse() {
        House house = new House();

        String name;
        do {
            System.out.print("Name: ");
            name = input.nextLine();
        } while (!Validate.checkNameAndStandard(name));
        house.setName(name);

        String id;
        do {
            System.out.print("ID: ");
            id = input.nextLine();
        } while (!Validate.checkIDHouse(id));
        house.setId(id);

        String area;
        do {
            System.out.print("Area: ");
            area = input.nextLine();
        } while (!Validate.checkArea(area));
        house.setArea(area);

        String amount;
        do {
            System.out.print("Amount: ");
            amount = input.nextLine();
        } while (!Validate.checkAmount(amount));
        house.setAmount(amount);

        String price;
        do {
            System.out.print("Price: ");
            price = input.nextLine();
        } while (!Validate.checkPrice(price));
        house.setPrice(price);

        String typeRents;
        do {
            System.out.print("Type Rents: ");
            typeRents = input.nextLine();
        } while (!Validate.checkTypeRent(typeRents));
        house.setTypeRents(typeRents);

        String standard;
        do {
            System.out.print("Standard Room: ");
            standard = input.nextLine();
        } while (!Validate.checkNameAndStandard(standard));
        house.setStandardRoom(standard);

        String floor;
        do {
            System.out.print("Floor: ");
            floor = input.nextLine();
        } while (!Validate.checkFloor(floor));
        house.setFloor(floor);

        String facilities;
        do {
            System.out.print("Other Facilities: ");
            facilities = input.nextLine();
        } while (!Validate.checkFacilities(facilities));
        house.setOtherFacilities(facilities);

        houseList.add(house);

        System.out.println("\nAdd new House completed!\n");
        FileCSV.writeServicesFileCSV(houseList, "house");
        addNewServices();
    }

    public static void addNewRoom() {
        Room room = new Room();

        String name;
        do {
            System.out.print("Name: ");
            name = input.nextLine();
        } while (!Validate.checkNameAndStandard(name));
        room.setName(name);

        String id;
        do {
            System.out.print("ID: ");
            id = input.nextLine();
        } while (!Validate.checkIDRoom(id));
        room.setId(id);

        String area;
        do {
            System.out.print("Area: ");
            area = input.nextLine();
        } while (!Validate.checkArea(area));
        room.setArea(area);

        String amount;
        do {
            System.out.print("Amount: ");
            amount = input.nextLine();
        } while (!Validate.checkAmount(amount));
        room.setAmount(amount);

        String price;
        do {
            System.out.print("Price: ");
            price = input.nextLine();
        } while (!Validate.checkPrice(price));
        room.setPrice(price);

        String typeRents;
        do {
            System.out.print("Type Rents: ");
            typeRents = input.nextLine();
        } while (!Validate.checkTypeRent(typeRents));
        room.setTypeRents(typeRents);

        String facilities;
        do {
            System.out.print("Other Facilities: ");
            facilities = input.nextLine();
        } while (!Validate.checkFacilities(facilities));
        room.setFreeService(facilities);

        roomList.add(room);

        System.out.println("\nAdd new Room completed!\n");
        FileCSV.writeServicesFileCSV(roomList, "room");
        addNewServices();
    }

    public static void showServices() {
        System.out.println("========== SHOW SERVICES ==========");
        System.out.println("1.Show all Villa");
        System.out.println("2.Show all House");
        System.out.println("3.Show all Room");
        System.out.println("4.Show All Name Villa Not Duplicate");
        System.out.println("5.Show All Name House Not Duplicate");
        System.out.println("6.Show All Name Room Not Duplicate");
        System.out.println("7.Back To Menu");
        System.out.println("8.Exit");
        System.out.println("===================================");
        System.out.print("Your choose: ");
        String choose = input.nextLine();

        switch (choose) {
            case "1": {
                showAllVilla();
                break;
            }
            case "2": {
                showAllHouse();
                break;
            }
            case "3": {
                showAllRoom();
                break;
            }
            case "4": {
                showNameVilla();
                break;
            }
            case "5": {
                showNameHouse();
                break;
            }
            case "6": {
                showNameRoom();
                break;
            }
            case "7": {
                displayMainMenu();
                break;
            }
            case "8": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail!!! Please Choose again! Enter to continue.");
                input.nextLine();
                showServices();
            }
        }
    }

    public static void showAllVilla() {
        for (Services villa : villaList) {
            System.out.println(villa.showInfo());
        }
        showServices();
    }

    public static void showAllHouse() {
        for (Services house : houseList) {
            System.out.println(house.showInfo());
        }
        showServices();
    }

    public static void showAllRoom() {
        for (Services room : roomList) {
            System.out.println(room.showInfo());
        }
        showServices();
    }

    public static void showNameVilla() {
        for (Services nameVilla : villaList) {
            nameVillaNotDuplicate.add(nameVilla.getName());
        }
        System.out.println(nameVillaNotDuplicate);
        displayMainMenu();
    }

    public static void showNameHouse() {
        for (Services nameHouse : houseList) {
            nameHouseNotDuplicate.add(nameHouse.getName());
        }
        System.out.println(nameHouseNotDuplicate);
        displayMainMenu();
    }

    public static void showNameRoom() {
        for (Services nameRoom : roomList) {
            nameRoomNotDuplicate.add(nameRoom.getName());
        }
        System.out.println(nameRoomNotDuplicate);
        displayMainMenu();
    }

    public static void addNewCustomer() {
        Customer customer = new Customer();
        System.out.print("Name: ");
        customer.setName(input.nextLine());
        System.out.print("Birthday: ");
        customer.setBirthday(input.nextLine());
        System.out.print("Gender: ");
        customer.setGender(input.nextLine());
        System.out.print("IdCard: ");
        customer.setIdCard(input.nextLine());
        System.out.print("PhoneNumber: ");
        customer.setPhoneNumber(input.nextLine());
        System.out.print("Email: ");
        customer.setEmail(input.nextLine());
        System.out.print("TypeCustomer: ");
        customer.setTypeCustomer(input.nextLine());
        System.out.print("Address: ");
        customer.setAddress(input.nextLine());
        customer.setServices(null);

        customerList.add(customer);
        FileCSV.writeFileCustomerToCSV(customerList);
        displayMainMenu();
    }

    public static void showCustomer() {
        Comparator<Customer> customerComparator = new CustomerComparator();
        Collections.sort(customerList, customerComparator);
        for (Customer customer : customerList) {
            System.out.println(customer.showInfo());
        }
        displayMainMenu();
    }

    public static void addNewBooking() {
        for (Customer customer : customerList) {
            System.out.println((customerList.indexOf(customer) + 1) + ". " + (customer.showInfo()));
        }
        System.out.print("Enter customer: ");
        String choose = input.nextLine();
        int index = Integer.parseInt(choose) - 1;
        Customer customer = customerList.get(index);
        System.out.println(customer);

        System.out.println("1.Booking Villa");
        System.out.println("1.Booking House");
        System.out.println("1.Booking Room");
        System.out.print("Your Choose: ");
        String chooseBooking = input.nextLine();

        switch (chooseBooking) {
            case "1": {
                Services villa = selectServices(villaList);
                if (bookingList.contains(customer)) {
                    customer.setServices(villa);
                } else {
                    customer.setServices(villa);
                    bookingList.add(customer);
                }
                break;
            }
            case "2": {
                Services house = selectServices(houseList);
                if (bookingList.contains(customer)) {
                    customer.setServices(house);
                } else {
                    customer.setServices(house);
                    bookingList.add(customer);
                }
                break;
            }
            case "3": {
                Services room = selectServices(roomList);
                if (bookingList.contains(customer)) {
                    customer.setServices(room);
                } else {
                    customer.setServices(room);
                    bookingList.add(customer);
                }
                break;
            }
        }
        FileCSV.writeFileCustomerToCSV(customerList);
        FileCSV.writeFileBookingToCSV(bookingList);
        displayMainMenu();
    }

    public static Services selectServices(List<Services> list) {
        for (Services services : list) {
            System.out.println((list.indexOf(services) + 1) + ". " + (services.showInfo()));
        }
        System.out.print("Enter services: ");
        String choose = input.nextLine();
        int index = Integer.parseInt(choose) - 1;
        Services services = list.get(index);
        return services;
    }

    public static void showInformationOfEmployee() {
        for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        displayMainMenu();
    }

    public static void main(String[] args) {
        villaList = FileCSV.readServicesFileCSV("villa");
        houseList = FileCSV.readServicesFileCSV("house");
        roomList = FileCSV.readServicesFileCSV("room");

        customerList = FileCSV.readFileCustomer(villaList, "SVVL");
        customerList.addAll(FileCSV.readFileCustomer(houseList, "SVHO"));
        customerList.addAll(FileCSV.readFileCustomer(roomList, "SVRO"));
        bookingList.addAll(customerList);
        customerList.addAll(FileCSV.readFileCustomer(null, "null"));

        employeeMap = FileCSV.readFileEmployee();
        displayMainMenu();
    }
}

