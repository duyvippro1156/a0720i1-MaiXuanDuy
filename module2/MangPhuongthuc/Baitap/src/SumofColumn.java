import java.util.Scanner;

public class SumofColumn {
    public static double sumOfColumn(int column, double arr[][]) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i][column];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap dong: ");
        int row = scanner.nextInt();
        System.out.print("Nhap cot: ");
        int column = scanner.nextInt();
        double array[][] = new double[row][column];
        System.out.println("Nhap phan tu vao mang");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                System.out.printf("Phan tu [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        System.out.print("Nhap cot ban muon tinh tong: ");
        int sumColumn = scanner.nextInt();
        if (sumColumn < 0 || sumColumn >= column){
            System.out.print("Khong ton tai cot");
        } else {
            double sum = sumOfColumn(sumColumn, array);
            System.out.print("Tong cac phan tu trong cot " + sumColumn + ": " + sum);
        }

    }

}
