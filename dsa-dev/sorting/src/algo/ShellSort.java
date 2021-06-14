package algo;

import java.util.Arrays;
import java.util.Comparator;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;
import algo.*;

/**
 * ShellSort = diminishing increment sort = n-gap insertion sort
 * https://youtu.be/DV8-AmwW1rw
 */

public class ShellSort extends AbstractSorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        final int n = values.length;
        int gap = (int) Math.floor(n / 2);
        // System.out.println(gap);

        int startPoint = 0;

        System.out.println("Before sorting\n");
        Utils.printArray(values);

        while (gap >= 1) {
            System.out.println("\n\nGap = " + gap);
            for (int i = startPoint; i < n - gap; i++) {
                System.out.println("Pass " + (i + 1));
                System.out.println("\tComparing " + values[i] + " and " + values[i + gap]);
                if (values[i].compareTo(values[i + gap]) > 0) {
                    swap(values, i, i + gap);
                    System.out.println("\t ==>Swapped " + values[i] + " and " + values[i + gap]);
                }
            }
            gap--;
            // startPoint++;
            System.out.println();
            Utils.printArray(values);
        }

        if (gap == 0) {
            Sortable insertionSorter = new InsertionSort();
            insertionSorter.sort(values, isAscending);
        }

    }
}
