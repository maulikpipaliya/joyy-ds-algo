package algo;

import java.util.Comparator;

import abstracts.Sorter;
import interfaces.Sortable;
import jdk.jshell.execution.Util;
import util.Utils;

/**
 *  1. Find the minimum value in the list
    2. Swap it with the value in the current position
    3. Repeat this process for all the elements until the entire array is sorted
This algorithm is called SelectionSort since it repeatedly selects the smallest element
 */

public class SelectionSort extends Sorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        int idx;

        for (int i = 0; i < values.length - 1; i++) {
            idx = i;
            for (int j = i + 1; j < values.length; j++) {
                if (isAscending) {
                    if (values[j].compareTo(values[idx]) < 0)
                        idx = j;
                } else {
                    if (values[j].compareTo(values[idx]) > 0)
                        idx = j;
                }
            }
            swap(values, i, idx);
        }
     

    }
}
