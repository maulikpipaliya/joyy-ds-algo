package algo;

import java.util.Comparator;

import abstracts.Sorter;
import interfaces.Sortable;
import util.Utils;

/**
 * 
 */

public class SelectionSort extends Sorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        int minIndex;
        for (int i = 0; i < values.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (isAscending) {
                    if (values[j].compareTo(values[minIndex]) < 0)
                        minIndex = j;
                } else {
                    if (values[j].compareTo(values[minIndex]) > 0)
                        minIndex = j;
                }
            }
            swap(values, i, minIndex);
        }

    }
}
