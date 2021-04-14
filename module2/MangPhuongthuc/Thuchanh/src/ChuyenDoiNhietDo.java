import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double F;
        double C;
        int choice;
        do {
            System.out.println("Menu.");
            System.out.println("1. F sang C");
            System.out.println("2. C sang F");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập độ F: ");
                    F = input.nextDouble();
                    System.out.println("F sang C: " + fahrenheitToCelsius(F));
                    break;
                case 2:
                    System.out.println("Nhập độ C: ");
                    C = input.nextDouble();
                    System.out.println("C sang F: " + celsiusToFahrenheit(C));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}
