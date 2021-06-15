
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
        SorterApp app = new SorterApp();
        boolean isAscending = true;

        if (args.length >= 1 && args[0].equals("desc"))
            isAscending = false;

        Random random = new Random();
        int n = random.nextInt(15) + 10;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(45);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        // app.sort(new Integer[] { 10, 4, 43, 5, 57, 91, 45, 9, 7 }, isAscending);
        // app.sort(new Integer[] { 23, 29,15,19,31,7,9,5,2 }, isAscending);
        app.sort(arr, isAscending);
    }

    private <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        Sortable sorter = new ShellSort();

        sorter.sort(values, isAscending); // ascending

        Utils.printArray(values);
    }
}