import java.util.Scanner;

public class Chuyendoitiente {
    public static void main(String[] args) {
        double rate = 23000.0;
        double USD;
        System.out.println("Nhập số tiền USD = ");
        Scanner sc = new Scanner(System.in);
        USD = sc.nextDouble();
        double VND = USD * rate;
        System.out.println("Số tiền VNĐ là: "+VND);
    }
}
