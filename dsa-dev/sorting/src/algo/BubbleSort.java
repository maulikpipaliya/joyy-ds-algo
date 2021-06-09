package algo;

import java.util.Comparator;

import abstracts.Sorter;
import interfaces.Sortable;
import util.Utils;

import java.util.logging.Logger;

/**
 * Worst case complexity : O(n^2) 
 * Best case complexity (Improved version) : O(n)
 * Worst case space complexity : O(1) auxiliary
 */

public class BubbleSort extends Sorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        int length = values.length;
        boolean isSorted;

        for (int i = 0; i < length - 1; i++) {
            System.out.print("\nIteration " + (i + 1) + " : ");
            if (isAscending) {
                isSorted = true;
                for (int j = 0; j < length - i - 1; j++) {
                    System.out.print("\n\tSub iteration " + (j + 1) + " : ");
                    if (values[j].compareTo(values[j + 1]) > 0) {
                        System.out.print("(" + values[j] + "," + values[j + 1] + ") ==> ");
                        isSorted = false;
                        swap(values, j, j + 1);
                        System.out.print("(" + values[j] + "," + values[j + 1] + ")\t");
                        System.out.print("Array: ");
                        Utils.printArray(values);
                    } else {
                        System.out.print("No swap\t\n");
                    }
                }

                if (isSorted) {
                    System.out.println("\n\nArray is sorted");
                    break;
                } else {
                    System.out.println();
                    System.out.println("\n\t" + values[length - i - 1] + " is bubbled up (set at correct sorting index)");
                }
            } else {

                isSorted = true;
                for (int j = 0; j < length - i; j++) {
                    System.out.print("\n\tSub iteration " + (j + 1) + " : ");

                    if (values[j].compareTo(values[j + 1]) < 0) {
                        System.out.print("(" + values[j] + "," + values[j + 1] + ") ==> ");

                        isSorted = false;
                        swap(values, j + 1, j);
                        System.out.print("(" + values[j] + "," + values[j + 1] + ")\t");
                        System.out.print("Array: ");
                        Utils.printArray(values);
                    } else {
                        System.out.print("No swap\t\n");
                    }
                }

                if (isSorted) {
                    System.out.println("\n\nArray is sorted");
                    break;
                } else {
                    System.out.println();
                    System.out.println("\n\t" + values[length - i] + " is bubbled up (set at correct sorting index)");
                }
            }
        }

    }
}
