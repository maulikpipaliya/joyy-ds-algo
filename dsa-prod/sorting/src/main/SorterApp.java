
/**
 * @author Maulik Pipaliya
 * SorterApp
 */


import util.Utils;
import interfaces.Sortable;
import algo.BubbleSort;
import algo.SelectionSort;

public class SorterApp {

    public static void main(String[] args) {
        SorterApp app = new SorterApp();
        app.run();
    }

    private void run() {
        sort(new Integer[] { 10, 4, 43, 5, 57, 91, 45, 9, 7 });
    }

    private <T extends Comparable<? super T>> void sort(T[] values) {
        Sortable sorter = new SelectionSort();

        boolean isAscending = false;
        sorter.sort(values, isAscending); // ascending
        
        Utils.printArray(values);
    }
}