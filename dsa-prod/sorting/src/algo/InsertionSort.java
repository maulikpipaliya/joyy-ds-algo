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

        for (int i = 1; i <= n - 1; i++) {
            insertItemIndex = i;
            insertItem = values[i];

            if (isAscending) {
                while (insertItemIndex >= 1 && values[insertItemIndex - 1].compareTo(insertItem) > 0) {

                    values[insertItemIndex] = values[insertItemIndex - 1];
                    insertItemIndex--;
                }
            } else {
                while (insertItemIndex >= 1 && values[insertItemIndex - 1].compareTo(insertItem) < 0) {
                    values[insertItemIndex] = values[insertItemIndex - 1];
                    insertItemIndex--;
                }
            }
            values[insertItemIndex] = insertItem;

        }

    }
}
