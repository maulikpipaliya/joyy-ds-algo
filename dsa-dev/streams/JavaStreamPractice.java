
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * 
 * @version >= 1.8
 * 
 * Java Streams - related to Collection Framework
 * 
 * Stream Source = Collections, Lists, Sets, ints, longs, doubles, arrays, lines
 * of a file Operations = intermediate, terminal operations
 * 
 * Intermediate operations - Order matters - ParallelStream for large datasets
 * 
 * anyMatch() distinct() filter() findFirst() map() flatmap() skip() sorted()
 * 
 * Terminal Operations = Only one is allowed
 * 
 * forEach() collect() - saves the elements into a collection count() max()
 * min() reduce() summaryStatistics()
 */

public class JavaStreamPractice {
    public static void main(String[] args) {
        System.out.println("Streams");

         
        List<Integer> numbers = List.of(2, 3, 8, 9, 11, 17, 18);
        Stream<Integer> stream = numbers.stream();
        
        System.out.println(
            numbers.stream().count()

        );
         


    }
}
