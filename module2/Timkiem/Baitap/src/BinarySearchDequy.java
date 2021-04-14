public class BinarySearchDequy {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2; // Tương đương (l+r)/2 nhưng ưu điểm tránh tràn số khi l,r lớn

            // Nếu arr[mid] = x, trả về chỉ số và kết thúc.
            if (arr[mid] == x)
                return mid;

            // Nếu arr[mid] > x, thực hiện tìm kiếm nửa trái của mảng
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Nếu arr[mid] < x, thực hiện tìm kiếm nửa phải của mảng
            return binarySearch(arr, mid + 1, r, x);
        }

        // Nếu không tìm thấy
        return -1;
    }

    public static void main(String[] args) {
        int n = list.length;
        System.out.println(binarySearch(list, 0, n - 1, 2));  /* 0 */
        System.out.println(binarySearch(list, 0, n - 1, 11)); /* 4 */
        System.out.println(binarySearch(list, 0, n - 1, 79)); /*12 */
        System.out.println(binarySearch(list, 0, n - 1, 1));  /*-1 */
        System.out.println(binarySearch(list, 0, n - 1, 5));  /*-1 */
        System.out.println(binarySearch(list, 0, n - 1, 80)); /*-1 */
    }
}

