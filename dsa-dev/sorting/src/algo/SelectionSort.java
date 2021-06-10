package algo;

import java.util.Comparator;

import abstracts.Sorter;
import interfaces.Sortable;
import util.Utils;

/**
 * 
 */

public class SelectionSort extends Sorter implements Sortable {
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
