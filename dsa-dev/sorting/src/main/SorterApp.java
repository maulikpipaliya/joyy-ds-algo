
/**
 * @author Maulik Pipaliya
 * SorterApp
 */


import util.Utils;
import interfaces.Sortable;
import algo.BubbleSort;

public class SorterApp {

    public static void main(String[] args) {
        System.out.println("Main");

        SorterApp app = new SorterApp();
        app.run();
    }

    private void run() {
        sort(new Integer[] { 10, 4, 43, 5, 57, 91, 45, 9, 7 });
    }

    private <T extends Comparable<? super T>> void sort(T[] values) {
        Sortable sorter = new BubbleSort();

        boolean isAscending = true;
        sorter.sort(values, isAscending); // ascending
        
        Utils.printArray(values);
    }
}