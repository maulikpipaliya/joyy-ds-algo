package util;


/**
 * @author Maulik Pipaliya
 *
 */


public class Utils {

    public static <T> void printArray(T[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}