package algo;

import java.util.Arrays;
import java.util.Comparator;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;
import algo.*;

/**
 * ShellSort = diminishing increment sort = n-gap insertion sort
 * 
 * makes several passes and uses various gaps between adjacent elements (ending with the gap of 1 or classical insertion sort)
 * 
 * Worst case Time Complexity : O( n * log^2(n)) 
 * Best case -> O(n)
 * Worst case Space Complexity : O(n)
 * 
 * https://youtu.be/DV8-AmwW1rw
 */

public class ShellSort extends AbstractSorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        final int n = values.length;

        System.out.println("Input Array\n");
        System.out.println("=========================\n");
        Utils.printArray(values);
        int nSwaps = 0;
        int first = 0, second = 0;
        int gap = n / 2; // normal shell sequence
        int nComparisons = 0;

        // Knuth Sequence

        // while (gap < values.length / 3) {
        // gap = 3 * gap + 1;
        // }

        boolean wentToSwap = false;
        while (gap > 0) {
            System.out.println("\n\nGap = " + gap);
            while ((second + gap) < n) {
                int idx1 = first;
                int idx2 = second + gap;

                System.out.println(values[idx1] + " and " + values[idx2]);

                wentToSwap = false;

                while (values[idx1].compareTo(values[idx2]) > 0) {
                    wentToSwap = true;
                    System.out.println("\tSwapped " + values[idx1] + " and " + values[idx2]);
                    nSwaps++;

                    swap(values, idx1, idx2);
                    if (idx1 >= gap) {
                        idx1 = idx1 - gap;
                        idx2 = idx2 - gap;
                    }
                    System.out.println("\t" + Arrays.toString(values));

                }
                if (!wentToSwap)
                    nComparisons++;
                first++;
                second++;
            }
            second = 0;
            first = 0;
            gap /= 2;
            // gap = --gap / 3;
        }

        nComparisons = nSwaps + nComparisons;

        System.out.println("=========================");
        System.out.println("is Proper Sorted: " + Utils.isSorted(values, isAscending));
        System.out.println("=========================");
        System.out.println("Number of Elements    =" + values.length);
        System.out.println("Number of Swaps       =" + nSwaps);
        System.out.println("Number of Comparisons =" + nComparisons);

    }

}
