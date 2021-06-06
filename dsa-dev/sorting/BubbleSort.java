package algo;

import abstracts.Sorter;
import interfaces.Sortable;

public class BubbleSort extends Sorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values) {
        int length = values.length;
        boolean isSorted;

        for (int i = 1; i < length; i++) {
            isSorted = true;

            for (int j = 0; j < length - i; j++) {
                if (values[j].compareTo(values[j + 1]) > 0) {
                    isSorted = false;
                    swap(values, j, j + 1);
                }
            }

            if (isSorted) {
                break;
            }
        }

    }
}
