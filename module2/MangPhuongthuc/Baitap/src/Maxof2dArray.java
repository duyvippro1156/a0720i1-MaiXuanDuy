import java.util.Scanner;

public class Maxof2dArray {
    public static int maxValue(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] > max)
                    max = array[i][j];

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap dong: ");
        int row = scanner.nextInt();
        System.out.print("Nhap cot: ");
        int column = scanner.nextInt();
        int array[][] = new int[row][column];
        System.out.println("Nhap phan tu");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                System.out.printf("Phan tu [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        int max = maxValue(array);
        System.out.print("Max cua mang la: " + max);
    }
}
