
/**
 * @author Maulik Pipaliya
 * SorterApp
 */

import util.Utils;
import interfaces.Sortable;
import algo.*;
import java.util.*;

public class SorterApp {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        SorterApp app = new SorterApp();
        boolean isAscending = true;

        if (args.length >= 1 && args[0].equals("desc"))
            isAscending = false;

        // app.sort(new Integer[] { 10, 4, 43, 5, 57, 91, 45, 9, 7 }, isAscending);
        
        // app.sort(new Integer[] { 43, 42, 40, 40, 39, 38, 32, 32, 31, 27, 25, 21, 20, 20, 18, 16, 12, 8, 7, 6, 4, 0 },
                // isAscending);
        app.sort(new Integer[] { 16,6,5,19,13,20,15,11,9,21 },
                isAscending);

        /*
         * Uncomment below code to create random array and comment above line
         */

        // Random random = new Random();
        // int n = random.nextInt(15) + 10;
        // Integer[] arr = new Integer[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = random.nextInt(45);
        // }
        // Arrays.sort(arr, Collections.reverseOrder());
        // app.sort(arr, isAscending);

        long endTime = System.nanoTime();

        System.out.println("==================================================");
        System.out.println("Took " + ((endTime - startTime) / 1000000) + " milliseconds");
    }

    private <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        Sortable sorter = new InsertionSort();
        System.out.println(sorter.getClass().getSimpleName());

        sorter.sort(values, isAscending); // ascending

        Utils.printArray(values);
    }
}