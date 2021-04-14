import java.util.Scanner;

public class Hienthicacloaihinh {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lựa chọn: ");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                int cd, cr;
                System.out.println("Nhập chiều dài: ");
                cd = sc.nextInt();
                System.out.println("Nhập chiều rộng: ");
                cr = sc.nextInt();
                for (int i = 1; i <= cr; i++) {
                    for (int j = 1; j <= cd; j++) {
                        System.out.print("* ");
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                int cc;
                System.out.println("Nhập chiều cao: ");
                cc = sc.nextInt();
                for (int i = 1; i <= cc; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.print("\n");
                }
                System.out.println("\n");
                for (int i = 1; i <= cc; i++) {
                    for (int j = cc; j >= i; j--) {
                        System.out.print("* ");
                    }
                    System.out.print("\n");
                }
                System.out.print("\n");
                for (int i = 0; i < cc; i++) {
                    for (int j = 0; j < i; j++)
                        System.out.print("  ");
                    for (int j = i; j < cc; j++)
                        System.out.print("* ");
                    System.out.print("\n");
                }
                System.out.print("\n");
                for (int i = cc; i >= 1; i--) {
                    for (int j = 1; j <= cc; j++) {
                        if (j < i) {
                            System.out.print("  ");
                        } else {
                            System.out.print("* ");
                        }
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                System.out.println("Nhập chiều cao: ");
                cc = sc.nextInt();
                for (int i = 5; i >= 1; i--) {
                    for (int j = 1; j <= cc; j++) {
                        if (j < i) {
                            System.out.print(" ");
                        } else {
                            System.out.print("* ");
                        }
                    }
                    System.out.print("\n");
                }
                break;
            case 4:
                System.exit(0);
        }
    }
}



