import java.util.*;

public class ArrayMath {
    public static void main(String[] args) {
        maximumSumTriplet();
    }

    public static void minStepsInInfiniteGrid() {
        ArrayList<Integer> A = new ArrayList<>(List.of(4, 8, -7, -5, -13, 9, -7, 8));
        ArrayList<Integer> B = new ArrayList<>(List.of(4, -15, -10, -3, -13, 12, 8, -8));
        System.out.println(coverPoints(A, B));
    }

    // Min Steps in Infinite Grid
    // https://www.interviewbit.com/old/problems/min-steps-in-infinite-grid/
    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        long shortestDistance = 0;
        int minSteps = 0;
        int srcX, srcY, destX, destY;
        if (A.size() == B.size()) {

            for (int i = 0; i < A.size() - 1; i++) {
                shortestDistance = 0;
                srcX = A.get(i);
                srcY = B.get(i);
                destX = A.get(i + 1);
                destY = B.get(i + 1);

                // Minimum of the difference = Diagonal Distance
                // Maximum = Total Distance
                shortestDistance = Math.abs(Math.max(Math.abs(srcX - destX), Math.abs(srcY - destY)));
                minSteps += shortestDistance;

            }
        }
        return minSteps;
    }

    // Minimum Lights to Activate
    // https://www.interviewbit.com/old/problems/minimum-lights-to-activate/
    public static void minimumLightsToActivate() {
        ArrayList<Integer> A = new ArrayList<>(List.of(0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0));
        Integer B = 6;
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int size = A.size();
        System.out.println(size % B);
        double minLightsNeeded = Math.floor(size / B);
        long workingLights = A.stream().filter(i -> i == 1).count();
        int nLights = 0;

        if (workingLights < minLightsNeeded) {
            return -1;
        } else {
            int min = 0;
            int max = 0;

            int n = A.size();
            // firstPosition = 1;
            // lastPosition = 13;

            // -2,8
            // 1,11
            // 2,12
            // 3,13

            while (max < n) {

                for (int i = 0; i < A.size(); i++) {
                    if (A.get(i) == 0)
                        continue;
                    if (A.get(i) == 1) {
                        if ((i - B) <= min && (i + B) >= max) {

                            max = i + B;
                        }
                    }
                }
                nLights++;
                if (min == max)
                    return -1;
                min = max;
            }

        }

        return nLights;

    }

    // Maximum Sum Triplet
    // https://www.interviewbit.com/old/problems/maximum-sum-triplet/
    public static void maximumSumTriplet() {
        // ArrayList<Integer> A = new ArrayList<>(List.of(18468, 6335, 26501, 19170,
        // 15725, 11479, 29359, 26963, 24465,
        // 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392,
        // 14605));
        ArrayList<Integer> A = new ArrayList<>(List.of(2, 5, 3, 1, 4, 9));

        System.out.println(maximumSumTripletSolution(A));
    }

    public static int maximumSumTripletSolution(ArrayList<Integer> A) {

        // O(n^2)

        // int max = 0;
        // for (int j = 1; j < A.size() - 1; j++) {
        // int maxLeft = 0;
        // int maxRight = 0;
        // System.out.println("For " + A.get(j));
        // for (int i = 0; i < j; i++) {
        // if (A.get(i) < A.get(j)) {
        // maxLeft = Math.max(A.get(i), maxLeft);
        // }
        // }
        // System.out.println("\tmaxLeft" + maxLeft);
        // for (int k = j + 1; k < A.size(); k++) {
        // if (A.get(k) > A.get(j)) {
        // maxRight = Math.max(A.get(k), maxRight);
        // }
        // }
        // System.out.println("\tmaxRight" + maxRight);
        // if (maxLeft > 0 && maxRight > 0) {

        // max = Math.max(max, maxRight + maxLeft + A.get(j));
        // }
        // }

        // return max;

        int sum = Integer.MIN_VALUE;
        int n = A.size();
        int[] rightMax = new int[n];

        // set the last element
        rightMax[n - 1] = A.get(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) > rightMax[i + 1]) {
                rightMax[i] = A.get(i);
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }

        System.out.println(Arrays.toString(rightMax));

        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(A.get(0));

        for (int i = 1; i < n - 1; i++) {
            Integer maxLeft = ts.lower(A.get(i));

            if (A.get(i) < rightMax[i + 1] && maxLeft != null) {
                sum = Math.max(sum, A.get(i) + maxLeft + rightMax[i + 1]);
            }
            ts.add(A.get(i));
        }

        return sum;

    }
}
