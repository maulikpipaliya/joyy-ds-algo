import java.util.*;
import java.util.stream.Collectors;

public class Arrangement {
    public static void main(String[] args) {
        // System.out.println("Hello");
        // largestNumber();
        // rotateMatrix();
        nextPermutation();
    }

    public static void largestNumber() {
        ArrayList<Integer> list = new ArrayList<Integer>(List.of(3, 30, 34, 5, 9));
        System.out.println(largestNumberSolution(list));
    }

    public static String largestNumberSolution(final List<Integer> A) {
        Comparator<Integer> lexCompare = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                String str1 = x.toString();
                String str2 = y.toString();

                return str1.concat(str2).toString().compareTo(str2.concat(str1).toString());
            }
        };
        long zeros = A.stream().filter(x -> x == 0).count();

        if (zeros == A.size())
            return "0";

        Collections.sort(A, lexCompare.reversed());

        return A.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public static void rotateMatrix() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        innerList.add(2);
        list.add(innerList);
        innerList = new ArrayList<>();
        innerList.add(3);
        innerList.add(4);
        list.add(innerList);

        rotateMatrixSolution(list);
    }

    public static void rotateMatrixSolution(ArrayList<ArrayList<Integer>> a) {
        System.out.println(a);

        int n = a.size();
        // n *= n;

        transposeMatrix(a);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(i).get(n - j - 1));
                a.get(i).set((n - j - 1), temp);
            }
        }
        System.out.println(a);

    }

    public static void transposeMatrix(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
                // swap(a, a.get(i).get(j), a.get(j).get(i));
            }
        }
    }

    public static void nextPermutation() {
        int a[] = { 1, 1, 4, 5, 1 };
        // int a[] = { 1, 2, 3 };
        System.out.println(Arrays.toString(nextPermutationSolution(a)));
    }

    // Intuition nicely explained in https://youtu.be/LuLCLgMElus
    // https://codeforces.com/blog/entry/3980
    public static int[] nextPermutationSolution(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // get the index from where increasing sequence breaks from the last
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // get element which is higher than nums[i] 
            while (j >= 0 && nums[j] <= nums[i])
                j--;

            int higherFromLast = j;
            swap(nums, i, higherFromLast);
        }

        //
        reverse(nums, i + 1, n - 1);

        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
