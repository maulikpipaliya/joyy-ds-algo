package util;

/**
 * @author Maulik Pipal public static <T> void printArray(T[] values) { for (int
 *         i = 0; i < values.length; i++) { System.out.print(values[i] + " ");
 *         }iya
 *
 */

public class Utils {

    public static <T> void printArray(T[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    //0, 1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484, 7174453, 21523360, 64570081, 193710244, 581130733
    public static int getKnuthSequenceNumber(int n ){
        return(int) ((Math.pow(3, n) - 1) / 2);
    }
}