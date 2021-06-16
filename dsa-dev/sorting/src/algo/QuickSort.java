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

    int nSwaps = 0, nComparisons = 0;

    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        final int n = values.length;
        System.out.println("Input Array\n");
        System.out.println("=========================\n");
        Utils.printArray(values);

        nComparisons = nSwaps + nComparisons;

        quickSort(values, 0, values.length - 1);

        System.out.println("=========================");
        System.out.println("is Proper Sorted: " + Utils.isSorted(values, isAscending));
        System.out.println("=========================");
        System.out.println("Number of Elements    =" + values.length);
        System.out.println("Number of Swaps       =" + nSwaps);
        System.out.println("Number of Comparisons =" + nComparisons);

    }

    public <T extends Comparable<? super T>> void quickSort(T[] values, int leftStart, int rightEnd) {
        System.out.println();
        System.out.print("(" + leftStart + "->" + rightEnd + ") = ");

        for (int i = leftStart; i <= rightEnd; i++) {
            System.out.print(values[i] + " ");
        }

        if (leftStart < rightEnd) {
            int pIdx = partition(values, leftStart, rightEnd);
            System.out.println("\tPartition Index is : " + pIdx);
            quickSort(values, leftStart, pIdx - 1);
            quickSort(values, pIdx + 1, rightEnd);
        } else {
            return;
        }

    }

    public <T extends Comparable<? super T>> int partition(T[] values, int leftStart, int rightEnd) {
        // select a pivot = always the right most one
        int pivot = rightEnd;
        int pIdx = leftStart; // left side from pIdx are smaller than pivot

        System.out.println("\n\tPivot is " + values[pivot] + " at index " + pivot);
        System.out.println("\n\tIndex: leftStart = " + leftStart + " rightEnd = " + rightEnd);

        for (int i = leftStart; i < rightEnd; i++) {
            // if value at pIdx is smaller, than swap (keeping all <pivot leftmost)
            if (values[i].compareTo(values[pivot]) <= 0) {
                swap(values, pIdx, i);
                pIdx++;
            }
        }

        swap(values, pivot, pIdx);
        System.out.println("After partitioning");
        Utils.printArray(values);
        return pIdx;
    }

}
