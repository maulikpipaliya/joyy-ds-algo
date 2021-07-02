import java.util.*;

public class ArrayMath {
    public static void main(String[] args) {
        System.out.println("Hello");
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

}
