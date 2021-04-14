package LuyentapCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static ArrayList<Product> productArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void mainMenu(){
        int choice;
        do{
            System.out.println("Menu");
            System.out.println("1. Thêm product");
            System.out.println("2. Sửa product");
            System.out.println("3. Xóa product");
            System.out.println("4. Hiển thị product");
            System.out.println("5. Tìm kiếm product theo tên");
            System.out.println("6. Sắp xếp product theo giá");
            System.out.println("7. Thoát");
            System.out.println("--------------------------------------------");
            choice = scanner.nextInt();
        }while (choice < 1 || choice > 7);
        switch (choice){
            case 1:
                add();
                break;
            case 2:
                edit();
                break;
            case 3:
                delete();
                break;
            case 4:
                show();
                break;
            case 5:
                search();
                break;
            case 6:
                System.out.println("Nhập 1 sắp xêp thấp -> cao \nNhập 2 sắp xếp theo cao > thấp");
                int choicee = scanner.nextInt();
                do{
                    if(choicee == 1){
                        sortAscending();
                    } else if(choicee == 2)
                        sortDescending();
                    }
                while (choicee <1 || choicee >2);
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Vui lòng nhập lựa chọn 1 -> 7");
        }
    }
    public static void add(){
        int idd;
        do {
            System.out.print("Nhập ID: ");
            idd = scanner.nextInt();
            if (searchById(idd) != null) {
                System.out.println("Id đã tồn tại, nhập id khác!");
            }
        } while (searchById(idd) != null);
        scanner.skip("\n");
        System.out.print("Nhập tên: ");
        String namee = scanner.nextLine();
        System.out.print("Nhập giá: ");
        Double pricee = scanner.nextDouble();
        Product product = new Product(idd, namee, pricee);
        productArrayList.add(product);
        System.out.println("Thêm "+product+ " thành công!");
        mainMenu();
    }
    public static void edit(){
        System.out.println("Nhập id cần sửa");
        int id = scanner.nextInt();
        Product product = searchById(id);
        if(product == null){
            System.out.println("Id không tồn tại!");
        }else{
            int choice;
            do {
                System.out.println("1: Sửa ID");
                System.out.println("2: Sửa Tên");
                System.out.println("1: Sửa Giá");
                choice = scanner.nextInt();
            }while (choice < 1|| choice > 3);
            switch (choice){
                case 1:
                    int newId;
                    do {
                        System.out.print("1. Nhập ID mới: ");
                        newId = scanner.nextInt();
                        if (searchById(newId) != null) {
                            System.out.println("Id đã tồn tại, nhập id khác!");
                        }
                    } while (searchById(newId) != null);
                    product.setId(newId);
                    break;
                case 2:
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    product.setName(newName);
                    break;
                case 3:
                    System.out.print("Nhập giá mới: ");
                    Double newPrice = scanner.nextDouble();
                    product.setPrice(newPrice);
                    break;
                default:
                    System.out.println("Nhập 1-3!");
            }
        }
        mainMenu();
    }
    public static void delete(){
        System.out.println("Nhập id cần xóa");
        int id = scanner.nextInt();
        Product product = searchById(id);
        if(product == null){
            System.out.println("Id không tồn tại!");
        }else{
            productArrayList.remove(product);
        }
        mainMenu();
    }
    public static void show(){
        for (Product product: productArrayList) {
            System.out.println(product);
        }
        mainMenu();
    }
    public static Product searchByName(String name){
        for(Product product: productArrayList){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
    public static void search(){
        System.out.print("Nhập tên cần tìm: ");
        scanner.skip("\n");
        String name = scanner.nextLine();
        Product product = searchByName(name);
        if(product == null){
            System.out.println("Tên không tồn tại");
        }else {
            System.out.println("Kết quả: "+ product);
        }
        mainMenu();
    }
    public static void sortAscending(){
        sortProductAscending sortProductAscending = new sortProductAscending();
        Collections.sort(productArrayList,sortProductAscending);
        show();
    }
    public static void sortDescending(){
        sortProductDescending sortProductDescending = new sortProductDescending();
        Collections.sort(productArrayList,sortProductDescending);
        show();
    }

    public static Product searchById(int id){
        for (Product product:productArrayList) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
