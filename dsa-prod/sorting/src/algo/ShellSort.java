package algo;

import java.util.Arrays;
import java.util.Comparator;

import abstracts.AbstractSorter;
import interfaces.Sortable;
import util.Utils;
import algo.*;

public class ShellSort extends AbstractSorter implements Sortable {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {

        final int n = values.length;
        int first = 0, second = 0;

        int gap = n / 2; // normal shell sequence

        int idx1, idx2;


        while (gap >=1) { // gap decreases by half everytime
            while ((second + gap) < n) { 
                idx1 = first;
                idx2 = second + gap;

                while (values[idx1].compareTo(values[idx2]) > 0) {

                    swap(values, idx1, idx2);
                    
                    // check backwards at the same gap if any out of order item.
                    if (idx1 >= gap) { 
                        idx1 = idx1 - gap;
                        idx2 = idx2 - gap;
                    }
                }
                first++;
                second++;
            }
            second = 0;
            first = 0;
            gap = gap / 2;
        }
    }

}
