public class TimGiaTriNhoNhatMethod {
    public static int minValue(int[] arr){
        int min = arr[0];
        int index = 1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
                index = j + 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int []arr = {4, 2, 7, 8, 5, 6, 9};
        int index = minValue(arr);
        System.out.println("Số nhỏ nhất trong mảng là: " + arr[index-1]);
    }
}
