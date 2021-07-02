import java.util.*;
import java.util.stream.*;

public class ListOps {

    public static void main(String[] args) {
        // List<Integer> list1 = getRandomNumbersList(10, 0, 100);
        // List<Integer> list = List.of(14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55,
        // 33, 96, 62, 32, 98, 77, 35);
        // List<Integer> list2 = rightShiftList(list, 56);

        List<Integer> list = Arrays.asList(1, 2, 5, -7, 2, 3);
        System.out.println("list2: " + getMaxNonNegativeSubArray(list));
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

    public static ArrayList<Integer> getMaxNonNegativeSubArray(List<Integer> list) {

        List<Integer> tempList = new ArrayList<Integer>();
        ArrayList<Integer> maxList = new ArrayList<Integer>();
        System.out.println(list);

        long max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            while (i < list.size() && list.get(i) >= 0) {
                tempList.add(list.get(i));
                i++;
            }

            long sum = tempList.stream().mapToLong(n -> n).sum();

            if (sum > max) {
                maxList = new ArrayList<Integer>(tempList);
                max = sum;
            }

            if (i < list.size() && list.get(i) < 0) {
                tempList.clear();
            }

            System.out.println("tempList: " + tempList);
        }

        System.out.println("maxList: " + maxList);

        return maxList;
    }

}
