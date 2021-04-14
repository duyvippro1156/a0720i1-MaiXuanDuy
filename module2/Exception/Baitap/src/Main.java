import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        try {
            CheckIllegalTriangleException check = new CheckIllegalTriangleException();
            System.out.println("Enter side1: ");
            check.setSide1(input.nextDouble());
            System.out.println("Enter side2: ");
            check.setSide2(input.nextDouble());
            System.out.println("Enter side3: ");
            check.setSide3(input.nextDouble());
        } catch (IllegalTriangleException e) {
            e.getMessage();
        }
    }
}