package algo;

import java.util.Arrays;
import java.util.Comparator;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;

/**
 *
 */

public class InsertionSort extends AbstractSorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        int n = values.length;
        T insertItem;
        int insertItemIndex;

        int nSwaps = 0, nComparisons = 0;
        boolean wentToSwap = false;

        System.out.println("Current Array: " + Arrays.toString(values));

        for (int i = 1; i <= n - 1; i++) {
            insertItemIndex = i;
            insertItem = values[insertItemIndex];

            wentToSwap = false;
            System.out.println("\n\nInserting item " + insertItem);
            if (isAscending) {
                while (insertItemIndex >= 1 && values[insertItemIndex - 1].compareTo(insertItem) > 0) {
                    // shifting right side
                    values[insertItemIndex] = values[insertItemIndex - 1];
                    insertItemIndex--;
                    nSwaps++;
                }
            } else {
                while (insertItemIndex >= 1 && values[insertItemIndex - 1].compareTo(insertItem) < 0) {
                    // shifting right side
                    values[insertItemIndex] = values[insertItemIndex - 1];
                    insertItemIndex--;
                    nSwaps++;
                }
            }

            if (!wentToSwap)
                nComparisons++;
            values[insertItemIndex] = insertItem;
            System.out.println("Item inserted at index " + insertItemIndex);
            Utils.printArray(values);
        }

        nComparisons = nSwaps + nComparisons;

        System.out.println("Number of Elements    =" + values.length);
        System.out.println("Number of Swaps       =" + nSwaps);
        System.out.println("Number of Comparisons =" + nComparisons);
    }
}
