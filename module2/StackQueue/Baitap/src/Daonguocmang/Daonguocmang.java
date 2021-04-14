package Daonguocmang;


import java.util.Scanner;
import java.util.Stack;

public class Daonguocmang {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        int[] intArr = {1, 2, 3, 4};
        for (int i = 0; i < intArr.length; i++) {
            intStack.push(intArr[i]);
        }
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = intStack.pop();
        }
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i] + "\t");
        }
        System.out.println("\n ----------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i< str.length(); i++){
            characterStack.push(str.charAt(i));
        }

        while (!characterStack.isEmpty()){
            System.out.print(characterStack.pop());
        }
        System.out.println("\n ----------------------------------------------------------------------");
        System.out.print("Nhập chuỗi: ");
        String str2 = scanner.nextLine();
        String[] arr = str2.split("\\s");
        Stack<String> stringStack = new Stack<>();
        for (int i=0 ; i< arr.length; i++){
            stringStack.push(arr[i]);
        }

        while (!stringStack.isEmpty()){
            System.out.print(stringStack.pop() +  " ");
        }
    }
}
