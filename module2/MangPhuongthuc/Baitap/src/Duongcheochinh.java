import java.util.Scanner;

public class Duongcheochinh {
    public static int sumOfDiagonal(int arr[][]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i][i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int size = scanner.nextInt();
        int array[][] = new int[size][size];
        System.out.println("Nhập phần tử: ");
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                System.out.printf("Phần tử [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        int sum = sumOfDiagonal(array);
        System.out.print("Tổng đường chéo chính của ma trận vuông: " + sum);

    }
}
