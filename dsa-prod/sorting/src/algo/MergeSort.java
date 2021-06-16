package algo;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;
import algo.*;
import java.lang.*;
import java.util.*;

/**
 * 
 * 
 */

public class MergeSort extends AbstractSorter implements Sortable {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        T[] arrayMerged = (T[]) new Comparable[values.length];
        makeHalves(arrayMerged, values, 0, values.length - 1);
    }

    public <T extends Comparable<? super T>> void makeHalves(T[] arrayMerged, T[] values, int leftStart, int rightEnd) {
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
        int arrayMergedPointer = leftStart; // values will be sorted and merged here

        while (leftArrayPointer <= mid && rightArrayPointer <= rightEnd) { // till when both array's values can be  compared. - same size
            if (values[leftArrayPointer].compareTo(values[rightArrayPointer]) > 0) // value from left array is big
                arrayMerged[arrayMergedPointer++] = values[rightArrayPointer++]; // push value from right array to  merged array
            else
                arrayMerged[arrayMergedPointer++] = values[leftArrayPointer++]; // push value from left array to merged array
        }

        // leftovers from arrays
        while (leftArrayPointer <= mid)
            arrayMerged[arrayMergedPointer++] = values[leftArrayPointer++];

        while (rightArrayPointer <= rightEnd)
            arrayMerged[arrayMergedPointer++] = values[rightArrayPointer++];

        // copying values to main array
        for (int i = 0; i < arrayMergedPointer; i++)
            values[i] = arrayMerged[i];
    }
}
