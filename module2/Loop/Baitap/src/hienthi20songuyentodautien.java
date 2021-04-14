import java.util.Scanner;

public class hienthi20songuyentodautien  {
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        double squareRoot = Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên cần hiển thị");
        number = sc.nextInt();
        int count = 0;
        int N = 2;
        while (count < number) {
            if (isPrimeNumber(N)){
                System.out.print(N+ " ");
                count++;
            }
            N++;
        }
    }
}
