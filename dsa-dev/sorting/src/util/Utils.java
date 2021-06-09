package util;


/**
 * @author Maulik Pipaliya
 *
 */


public class Utils {
    public static void clearScreen() {
        // clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static <T> void printArray(T[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}