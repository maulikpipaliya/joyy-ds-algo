import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class MergeSortArray {
    private long[] array;
    private int nElems;
    private int arrayCapacity;
    private long[] temp = new long[arrayCapacity];

    public MergeSortArray(int maxSize) {
        this.arrayCapacity = maxSize;
        array = new long[this.arrayCapacity];
        temp = new long[this.arrayCapacity];
    }

    public void insert(long datum) {
        array[nElems++] = datum;
    }

    public void display() {
        System.out.println(Arrays.toString(this.array));
    }

    public void mergeSort(int leftStart, int rightEnd) {
        System.out.println();
        System.out.print("(" + leftStart + "->" + rightEnd + ") = ");
        for (int i = leftStart; i <= rightEnd; i++) {
            System.out.print(array[i] + " ");
        }

        if (leftStart < rightEnd) { // no single element
            // Finding mid point
            int mid = (leftStart + rightEnd) / 2;
            mergeSort(leftStart, mid);
            mergeSort(mid + 1, rightEnd);
            mergeHalves(leftStart, mid, rightEnd);
        } 
        else {
            return;
        }
    }

    public void mergeHalves(int l, int m, int r) {
        System.out.println("\n\nMerging subarrays");
        System.out.println("L = " + l + ", R = " + r + ", Mid =  " + m);
        for (int i = l; i <= m; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("| ");
        for (int i = m + 1; i <= r; i++) {
            System.out.print(array[i] + " ");
        }

        // i(L-Mid), j(Mid-R) -> k(L-R)
        int i = l;
        int j = m + 1;
        int k = l;

        while (i <= m && j <= r) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= m) {
            temp[k++] = array[i++];
        }
        while (j <= r) {
            temp[k++] = array[j++];
        }

        //to copy temp array to main array
        for (int d = 0; d < k; d++) {
            array[d] = temp[d];
        }

        System.out.println("\nArray merged :" + Arrays.toString(temp));

    }

}

public class MergeSortApp {
    public static void main(String[] args) {

        // long[] a = {2, -1, 5, 0, 7, 3, -4, 6};
        // long[] a = {2,4,1,6,8,5,3,7};
        // long[] a = {9,7,3,6,2,1,4,11};
        // long[] a = {43,42,40,40,39,38,32,32,31,27,25,21,20,20,18,16,12,8,7,6,4,0};
        long[] a = {10, 4, 43, 5, 57, 91, 45, 9, 7};
        int arrayLen = a.length;

        MergeSortArray array = new MergeSortArray(arrayLen);

        for (int i = 0; i < a.length; i++) {
            // array.insert(new Random().nextInt(10));
            array.insert(a[i]);
        }

        array.display();
        array.mergeSort(0, arrayLen - 1); // 0,7
    }
}
