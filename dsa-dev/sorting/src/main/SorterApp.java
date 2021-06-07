
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
        sort(new Integer[] { 100,43,78,4,65, 45, 15, 95, 4, 7, 3, 1 });
    }

    private <T extends Comparable<? super T>> void sort(T[] values) {
        Sortable sorter = new BubbleSort();
        sorter.sort(values); // ascending
        Utils.printArray(values);
    }
}