import java.util.Scanner;

public class Docsothanhchu {
    final static String[] ONES = {" ", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX", " SEVEN", " EIGHT", " NINE", " TEN", " ELEVEN", " TWELVE", " THIRTEEN", " FOURTEEN", " FIFTEEN", " SIXTEEN", " SEVENTEEN", " EIGHTEEN", " NINETEEN"};
    final static String[] TENS = {" ", " ", " TWENTY", " THIRTY", " FORTY", " FIFTY", " SIXTY", " SEVENTY", " EIGHTY", " NINETY"};

    private static void readNumber(int number, String word) {
        System.out.print(number > 19 ? TENS[number / 10] + " " + ONES[number % 10] : ONES[number]);
        System.out.print(number > 0 ? " " + word : " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number");
        int num = input.nextInt();
        readNumber(((num / 1000)%100),"THOUSAND");
        readNumber(((num / 100) % 10), "HUNDRED");
        readNumber((num % 100)," ");

    }
}
