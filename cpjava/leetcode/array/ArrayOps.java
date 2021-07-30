import java.util.*;

public class ArrayOps {
    public static void main(String[] args) {
        System.out.println("Hello");
        // int[] arr1 = { 4, 9, 5 };
        int[] arr1 = {};
        // int[] arr2 = { 9, 4, 9, 8, 4 };
        // System.out.println(Arrays.toString(intersectionOfTwoArrays(arr1, arr2)));
        System.out.println(Arrays.toString(plusOne(arr1)));
    }

    public static int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int num : nums1)
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);

        List<Integer> ans = new ArrayList<Integer>();

        for (int num : nums2) {
            if (hmap.containsKey(num) && hmap.get(num) > 0) {
                ans.add(num);
                hmap.put(num, hmap.get(num) - 1);
            }
        }
        // System.out.println(hmap);

        int idx = 0;
        int[] answer = new int[ans.size()];
        for (Integer i : ans)
            answer[idx++] = i;

        return answer;

    }


    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

}
