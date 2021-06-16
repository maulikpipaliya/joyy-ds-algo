package algo;

import java.util.Comparator;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;

/**
 * selection sort improves on the bubble sort by making only one exchange for every pass through the list
 * 
 * looks for the smallest (or largest) value as it makes a pass and, after completing the pass, places it in the proper location
 * 
 * works well for small files
 * 
 * Time Complexity : O(n^2)
 * Space Complexity : O(1)
 */

public class SelectionSort extends AbstractSorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        int idx;

        String minMax = isAscending ? "Minimum" : "Maximum";

        System.out.println("Selecting " + minMax + " in each pass");

        for (int i = 0; i < values.length - 1; i++) {
            System.out.println("\nPass " + (i + 1));
            Utils.printArray(values);
            idx = i;
            for (int j = i + 1; j < values.length; j++) {
                if (isAscending) {
                    if (values[j].compareTo(values[idx]) < 0)
                        idx = j;
                } else {
                    if (values[j].compareTo(values[idx]) > 0)
                        idx = j;
                }
            }
            System.out.println(minMax + " is " + values[idx]);
            System.out.println("Swap " + values[i] + " and  " + values[idx]);
            System.out.println("Sorted till index " + i);
            swap(values, i, idx);
          

        }
        
        System.out.println("List is ordered");
    }
}
