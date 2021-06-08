package algo;

import abstracts.Sorter;
import interfaces.Sortable;

public class InsertionSort extends Sorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        if ((null == values) || (values.length < 2)) {
            return;
        }

        int length = values.length;
        int count = 0;
        int j;

        for (int i = 1; i < length; i++) {
            j = i;
            count++;
            while ((j > 0) && (values[j].compareTo(values[j - 1]) < 0)) {
                swap(values, j, j - 1);
                j--;
                count++;
            }
        }
    }
}
