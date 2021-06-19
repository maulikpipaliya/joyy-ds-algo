import java.util.*;
import java.util.stream.*;

public class ListOps {

    public static void main(String[] args) {
        // List<Integer> list1 = getRandomNumbersList(10, 0, 100);
        // List<Integer> list = List.of(14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35);
        // List<Integer> list2 = rightShiftList(list, 56);
        
        
        List<Integer> list = List.of(1, 2, 5, -7, 2, 3);
        System.out.println("list2: " + list2.getMaxNonNegativeSubArray());
    }

    public static List<Integer> getRandomNumbersList(int size, int min, int max) {
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max - min) + min);
        }
        Collections.shuffle(list);
        return list;
    }

    public static <T> List<T> rightShiftList(List<T> list, int position) {

        int offset = position % list.size();

        List<T> tail = list.subList(offset, list.size());
        List<T> head = list.subList(0, offset);

        List<T> combinedList = Stream.of(tail, head).flatMap((x) -> x.stream()).collect(Collectors.toList());
        return combinedList;
    }

    public static ArrayList<Integer> getMaxNonNegativeSubArray(ArrayList<Integer> list) {
        
        

        return new ArrayList<Integer>();
    }

}
