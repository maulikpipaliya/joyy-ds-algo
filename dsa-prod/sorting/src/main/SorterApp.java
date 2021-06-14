
/**
 * @author Maulik Pipaliya
 * SorterApp
 */


import util.Utils;
import interfaces.Sortable;
import algo.*;

public class SorterApp {

    public static void main(String[] args) {
        SorterApp app = new SorterApp();
        boolean isAscending = true;
    
        if (args.length >= 1 && args[0].equals("desc")) 
            isAscending = false;
    
        app.sort(new Integer[] { 10, 4, 43, 5, 57, 91, 45, 9, 7 }, isAscending);
    }

    private <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending) {
        Sortable sorter = new ShellSort();
        sorter.sort(values, isAscending); // ascending
        
        Utils.printArray(values);
    }
}