package util;

import java.util.*;

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

    public static <T extends Comparable<? super T>> boolean isSorted(T[] values, boolean isAscending) {
        int n = values.length;
        if (n == 0 || n == 1)
            return true;

        if (isAscending) {
            for (int i = 0; i < n - 1; i++)
                if (values[i].compareTo(values[i + 1]) > 0)
                    return false;
        } else {
            for (int i = 0; i < n - 1; i++)
                if (values[i].compareTo(values[i + 1]) < 0)
                    return false;
        }
        return true;
    }

}