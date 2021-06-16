package algo;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;
import algo.*;
import java.lang.*;
import java.util.*;

/**
 *
 * pivot value = A quick sort first selects an element from list
 * 
 * 
 * Worst case complexity : Θ(n * log n)
 */

public class QuickSort extends AbstractSorter implements Sortable {

    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        quickSort(values, 0, values.length - 1);
    }

    public <T extends Comparable<? super T>> void quickSort(T[] values, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int pIdx = partition(values, leftStart, rightEnd);
            quickSort(values, leftStart, pIdx - 1);
            quickSort(values, pIdx + 1, rightEnd);
        } else {
            return;
        }

    }

    public <T extends Comparable<? super T>> int partition(T[] values, int leftStart, int rightEnd) {
        // select a pivot = (here) always the right most one
        int pivot = rightEnd;
        int pIdx = leftStart; // left side from pIdx are smaller than pivot

        for (int i = leftStart; i < rightEnd; i++) {
            // if value at pIdx is smaller, than swap (keeping all <pivot leftmost)
            if (values[i].compareTo(values[pivot]) <= 0) {
                swap(values, pIdx, i);
                pIdx++;
            }
        }
        swap(values, pivot, pIdx);
        return pIdx;
    }

}
