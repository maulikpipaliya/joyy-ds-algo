package algo;

import java.util.Arrays;
import java.util.Comparator;

import abstracts.Sorter;
import interfaces.Sortable;
import util.Utils;

/**
 *
 */

public class InsertionSort extends Sorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        int n = values.length;
        T value;
        int hole;

        System.out.println(Arrays.toString(values));


        for (int i = 1; i <= n - 1; i++) {
            hole = i;
            value = values[i];
            System.out.println(hole);
            while (hole >= 1 && values[hole - 1].compareTo(value) > 0) {
                //shifting right side
                values[hole] = values[hole - 1];
                hole--;
            }
            values[hole] = value;
        }

    }
}
