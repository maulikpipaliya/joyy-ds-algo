package algo;

import java.util.Comparator;

import abstracts.Sorter;
import interfaces.Sortable;
import util.Utils;
/**
 * Worst case complexity : O(n^2) Best case complexity (Improved version) : O(n)
 * Worst case space complexity : O(1) auxiliary
 */

public class BubbleSort extends Sorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        int length = values.length;
        boolean isSorted;

        for (int i = 0; i < length-1; i++) {
            isSorted = true;

            for (int j = 0; j < length - i - 1; j++) {

                if (isAscending) {
                    if (values[j].compareTo(values[j + 1]) > 0) {
                        isSorted = false;
                        swap(values, j, j + 1);
                    }
                } else {
                    if (values[j].compareTo(values[j + 1]) < 0) {
                        isSorted = false;
                        swap(values, j + 1, j);
                    }
                }
            }

            if (isSorted)
                break;

        }

    }
}
