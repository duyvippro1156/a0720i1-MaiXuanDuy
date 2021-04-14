import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int k = i - 1;
            for (; k >= 0 && array[k] > currentElement; k--) {
                array[k + 1] = array[k];
            }
            if (currentElement == array[k + 1]) {
                continue;
            } else {
                System.out.println("Chèn " + currentElement + " trước " + array[k + 1]);
            }
            array[k + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int[] myArray = {2, 9, 5, 4, 8, 1};
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}


