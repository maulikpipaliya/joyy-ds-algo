public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new Integer[] { 4, 7, 9, 23, 43, 67, 78, 109 }, 44));
    }

    public static int binarySearch(Integer[] array, int x) {
        int low = 0, high = array.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == x)
                return mid;
            else {
                if (x > array[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return Integer.MIN_VALUE;
    }
}
