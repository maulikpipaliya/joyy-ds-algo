package util;

/**
 * @author Luciano Sampaio
 * 
 */
public class Utils {

  /**
   * Print all the elements of the array.
   * 
   * @param values
   */
  public static <T> void printArray(T[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.printf("%-2s", values[i]);
    }
    System.out.println();
  }
}
