import java.util.*;

public class ArrayMath {
    public static void main(String[] args) {
        // maximumSumTriplet();

        // addOneToNumber();
        // maximumAbsoluteDifference();
        // partitions();
        maximumAreaOfTriangle();
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

    public static void maxSumContiguousSubarray() {
        ArrayList<Integer> A = new ArrayList<>(List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        System.out.println(maxSumContiguousSubarraySolution(A));
    }

    // https://youtu.be/VMtyGnNcdPw
    // includes Kadane's Algorithm
    public static int maxSumContiguousSubarraySolution(final List<Integer> A) {

        int maxSum = Integer.MIN_VALUE;
        int n = A.size();

        // O (n^3)

        // int sum = 0;
        // for (int i = 0; i < n; i++) {
        // for (int j = i; j < n; j++) {
        // sum = 0;
        // for (int k = i; k < j; k++) {
        // sum += A.get(k);
        // System.out.print(A.get(k) + " ");
        // }
        // maxSum = Math.max(sum, maxSum);
        // System.out.println();
        // }
        // System.out.println();
        // }

        // ---------------------

        // Prefix Sum Array Method

        // int[] prefixSumArray = new int[n];

        // int prefixSum = 0;
        // for (int i = 0; i < n; i++) {
        // prefixSum += A.get(i);
        // prefixSumArray[i] = prefixSum;
        // }

        // System.out.println(Arrays.toString(prefixSumArray));
        // int sum = 0;
        // for (int i = 0; i < n; i++) {
        // for (int j = i; j < n; j++) {
        // System.out.print(prefixSumArray[j] + " - " + prefixSumArray[i]);
        // sum = prefixSumArray[j] - prefixSumArray[i];
        // System.out.println(sum);
        // maxSum = Math.max(sum, maxSum);
        // System.out.println();
        // }
        // // System.out.println();
        // }

        int localMax = A.get(0);
        maxSum = A.get(0);

        int tempSum1 = 0;
        for (int i = 1; i < n; i++) {
            tempSum1 = localMax + A.get(i);
            localMax = Math.max(tempSum1, A.get(i));
            maxSum = Math.max(localMax, maxSum);
        }
        return maxSum;

    }

    public static void addOneToNumber() {
        ArrayList<Integer> A = new ArrayList<>(List.of(0, 6, 0, 6, 4, 8, 8, 1));
        addOneToNumberSolution(A);
    }

    public static ArrayList<Integer> addOneToNumberSolution(ArrayList<Integer> A) {

        int n = A.size();
        final int addValue = 1;
        int carry = 1;
        int i = n - 1;

        while (carry != 0 && i >= 0) {
            if (A.get(i) == 9) {
                A.set(i, 0);
                carry = 1;
            } else {
                A.set(i, A.get(i) + 1);
                carry = 0;
            }
            i--;
        }

        if (carry == 1) {
            A.add(0, carry);
        }

        i = 0;
        System.out.println(A);
        while (A.get(i) == 0) {
            A.remove((int) i);
            System.out.println(A);
        }

        return A;
    }

    public static void maximumAbsoluteDifference() {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 3, -1));
        System.out.println(maximumAbsoluteDifferenceSolution(A));
    }

    // https://youtu.be/tN8wEDNZKF4
    public static int maximumAbsoluteDifferenceSolution(ArrayList<Integer> A) {
        int maxAk1 = Integer.MIN_VALUE;
        int minAk1 = Integer.MAX_VALUE;
        int maxAk2 = Integer.MIN_VALUE;
        int minAk2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            maxAk1 = Math.max(A.get(i) + i, maxAk1);

            minAk1 = Math.min(A.get(i) + i, minAk1);
            maxAk2 = Math.max(A.get(i) - i, maxAk2);
            minAk2 = Math.min(A.get(i) - i, minAk2);
        }

        return Math.max(maxAk1 - minAk1, maxAk2 - minAk2);
    }

    public static void partitions() {
        ArrayList<Integer> A = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        System.out.println(partitionsSolution(9, A));
    }

    public static int partitionsSolution(int size, ArrayList<Integer> B) {
        int n = size;
        int nWays = 0;
        int sum = B.stream().mapToInt(i -> i).sum();
        int nFirstBar = 0;
        int nLastBar = 0;
        if (sum % 3 == 0) {
            int divSum = sum / 3;
            int[] prefixSumArray = new int[n];
            int[] suffixSumArray = new int[n];
            prefixSumArray[0] = B.get(0);
            suffixSumArray[n - 1] = B.get(n - 1);

            // if (suffixSumArray[n - 1] == divSum)
            // nLastBar++;
            // if (prefixSumArray[0] == divSum) {
            // nFirstBar++;
            // }

            List<Integer> prefix = new ArrayList<Integer>();
            List<Integer> suffix = new ArrayList<Integer>();

            int tempSum1 = 0;
            int tempSum2 = 0;
            int i = 0;
            for (i = 0; i < n; i++) {
                prefixSumArray[i] = prefixSumArray[i - 1] + B.get(i);
                // suffixSumArray[n - i - 1] = suffixSumArray[n - i] + B.get(n - i - 1);
                tempSum1 += B.get(i);
                if (tempSum1 == divSum) {
                    prefix.add(i);
                }
                tempSum2 += B.get(n - i - 1);
                if (tempSum2 == divSum) {
                    suffix.add(n - i - 1);
                }

            }
            System.out.println(prefix);
            System.out.println(suffix);

            for (i = 0; i < prefix.size(); i++) {
                for (int j = 0; j < suffix.size(); j++) {
                    // int mainSum = 0;
                    // int x = 0;
                    // // System.out.println(B.get(suffix.get(j)));
                    // for (int k =prefix.get(i)+1; k < suffix.get(j); k++) {
                    // mainSum += B.get(k);
                    // // System.out.println("ms" + mainSum);
                    // x = 1;
                    // }
                    // // System.out.println("ms" + mainSum);
                    // if (mainSum == divSum && x==1) {
                    // nWays++;
                    // }

                }
            }

            // i = 0;
            // while (i < n-1) {
            // if (prefixSumArray[i] == divSum) {
            // nFirstBar++;
            // if (prefixSumArray[i + 1] != divSum) {
            // break;
            // }
            // }
            // i++;
            // }
            // i = n-1;
            // while (i > 1) {
            // if (suffixSumArray[i] == divSum) {
            // nLastBar++;
            // if (suffixSumArray[i - 1] != divSum) {
            // break;
            // }
            // }
            // i--;
            // }

            // System.out.println(Arrays.toString(prefix));
            // System.out.println(Arrays.toString(suffix));
            System.out.println("divSum" + divSum);
            System.out.println("nWays" + nWays);
            System.out.println(prefix);
            System.out.println(suffix);
            System.out.println(nFirstBar);
            System.out.println(nLastBar);
        }

        return nWays;

    }

    public static void maximumAreaOfTriangle() {
        ArrayList<String> A = new ArrayList<>(List.of("rrrrr", "rrrrg", "rrrrr", "bbbbb"));
        System.out.println(maximumAreaOfTriangleSolution(A));

    }

    public static int maximumAreaOfTriangleSolution(ArrayList<String> A) {
        int maxArea = 0;

        int r = A.size();
        int c = A.get(0).length();

        System.out.println(r);
        System.out.println(c);

        int start = 0;
        int end = 0;
        final char[] colors = { 'r', 'g', 'b' };
        final boolean[] colorsTaken = { false, false, false };
        int maxColumnLength = r;

        for (int i = 0; i < r; i++) {
            if (A.get(i).charAt(0) != A.get(r - i - 1).charAt(0)) {
                start = i;
                end = r - i - 1;
 
                // colorsTaken[start] = true;
                // colorsTaken[end] = true;

                maxColumnLength = r - i;
                break;
            }
        }

        System.out.println("maxColumnLength" + maxColumnLength);
        int rightI = 0;
        int rightJ = 0;
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (A.get(i).charAt(j) == 'g') {
                    rightI = i;
                    rightJ = j;
                }
            }
        }

        int x1 = 0, x2 =0, x3 = rightJ, y1 = start, y2 = end, y3=rightI;  

        double area =  (1/2) * (x1 * (y2-y3 ) + x2* (y3- y1 ) + x3*(y1- y2));



        System.out.println("start" + start);
        System.out.println("end" + end);
        System.out.println("rightI" + rightI);
        System.out.println("rightJ" + rightJ);
        System.out.println("area" +area);


        return maxArea;
    }

}
