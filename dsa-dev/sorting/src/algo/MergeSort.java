package algo;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;
import algo.*;
import java.lang.*;
import java.util.*;

/**
 *
 * Worst case complexity : Θ(n * log n)
 */

public class MergeSort extends AbstractSorter implements Sortable {

    int nSwaps = 0, nComparisons = 0;

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        final int n = values.length;
        System.out.println("Input Array\n");
        System.out.println("=========================\n");
        Utils.printArray(values);

        nComparisons = nSwaps + nComparisons;

        T[] arrayMerged = (T[]) new Comparable[values.length];

        makeHalves(arrayMerged, values, 0, values.length - 1);

        System.out.println("=========================");
        System.out.println("is Proper Sorted: " + Utils.isSorted(values, isAscending));
        System.out.println("=========================");
        System.out.println("Number of Elements    =" + values.length);
        System.out.println("Number of Swaps       =" + nSwaps);
        System.out.println("Number of Comparisons =" + nComparisons);

    }

    public <T extends Comparable<? super T>> void makeHalves(T[] arrayMerged, T[] values, int leftStart, int rightEnd) {
        System.out.println();
        System.out.print("(" + leftStart + "->" + rightEnd + ") = ");

        for (int i = leftStart; i <= rightEnd; i++) {
            System.out.print(values[i] + " ");
        }

        if (leftStart < rightEnd) {
            int mid = (leftStart + rightEnd) / 2;
            makeHalves(arrayMerged, values, leftStart, mid);
            makeHalves(arrayMerged, values, mid + 1, rightEnd);
            sortAndMergeHalves(arrayMerged, values, leftStart, mid, rightEnd);
        } else {
            return;
        }
    }

    public <T extends Comparable<? super T>> void sortAndMergeHalves(T[] arrayMerged, T[] values, int leftStart,
            int mid, int rightEnd) {

        // 3 pointers
        int leftArrayPointer = leftStart;
        int rightArrayPointer = mid + 1;
        int arrayMergedPointer = leftStart;
        // T[] arrayMerged = (T[]) new Comparable[values.length];

        System.out.println("\n\nMerging subarrays");

        System.out.println("L = " + leftStart + ", R = " + rightEnd + ", Mid =  " + mid);
        for (int i = leftStart; i <= mid; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.print(" | ");
        for (int i = mid + 1; i <= rightEnd; i++) {
            System.out.print(values[i] + " ");
        }

        System.out.println();
        // System.out.println("leftStart = " + leftStart + ".. mid = " + mid + "
        // ..rightEnd = " + rightEnd);

        while (leftArrayPointer <= mid && rightArrayPointer <= rightEnd) {
            nComparisons++;
            if (values[leftArrayPointer].compareTo(values[rightArrayPointer]) > 0) {
                arrayMerged[arrayMergedPointer++] = values[rightArrayPointer++];
            } else {
                arrayMerged[arrayMergedPointer++] = values[leftArrayPointer++];

            }
        }

        while (leftArrayPointer <= mid) {
            arrayMerged[arrayMergedPointer++] = values[leftArrayPointer++];
        }

        while (rightArrayPointer <= rightEnd) {
            arrayMerged[arrayMergedPointer++] = values[rightArrayPointer++];
        }

        for (int i = 0; i < arrayMergedPointer; i++) {
            values[i] = arrayMerged[i];
        }

        System.out.println(Arrays.toString(arrayMerged));

    }
}
