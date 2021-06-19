import java.io.*;
import java.util.*;

public class MatrixOps {

    PrintWriter w = new PrintWriter(System.out, true);

    public static void main(String[] args) {

        // int[][] matrix = { { 1 }, { 2 }, { 3 } };
        // int[][] matrix = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

        // 3*3 matrix
        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // 4*4 matrix
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
        14, 15, 16 } };
        prettyPrint(matrix);

        System.out.println(Arrays.toString(getSpiralOrder2(matrix)));
    }

    public static void prettyPrint(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] getSpiralOrder2(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        List<Integer> spiralOrder = new ArrayList<Integer>();

        if (nRows == 0)
            return spiralOrder.stream().mapToInt(i -> i).toArray();

        // int topLeft = 0, topRight = 0, bottomLeft = 0, bottomRight = 0;
        int hrUp = 0, vrRight = nCols - 1;
        int hrDown = nRows - 1, vrLeft = 0;

        while (hrUp <= hrDown && vrLeft <= vrRight) {

            for (int i = vrLeft; i <= vrRight; i++) {
                spiralOrder.add(matrix[hrUp][i]);
            }
            hrUp++;

            for (int j = hrUp; j <= hrDown; j++) {
                spiralOrder.add(matrix[j][vrRight]);
            }
            vrRight--;

            if (hrUp <= hrDown) {
                for (int k = vrRight; k >= vrLeft; k--) {
                    spiralOrder.add(matrix[hrDown][k]);
                }
                hrDown--;
            }

            if (vrLeft <= vrRight) {
                for (int l = hrDown; l >= hrUp; l--) {
                    spiralOrder.add(matrix[l][vrLeft]);
                }
                vrLeft++;
            }
            System.out.println(spiralOrder);
        }

        return spiralOrder.stream().mapToInt(i -> i).toArray();
    }

    public static int[] getSpiralOrder1(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        List<Integer> spiralOrder = new ArrayList<Integer>();

        if (nRows == 0)
            return spiralOrder.stream().mapToInt(i -> i).toArray();

        // int topLeft = 0, topRight = 0, bottomLeft = 0, bottomRight = 0;
        int hrUp = 0, vrRight = nCols - 1;
        int hrDown = nRows - 1, vrLeft = 0;

        boolean[][] visited = new boolean[nRows][nCols];

        while (hrUp <= hrDown && vrLeft <= vrRight) {
            for (int i = hrUp; i <= vrRight; i++) {
                spiralOrder.add(matrix[hrUp][i]);
            }
            hrUp++;

            for (int j = hrUp; j <= hrDown; j++) {
                spiralOrder.add(matrix[j][vrRight]);
            }
            vrRight--;

            for (int k = vrRight; k >= vrLeft; k--) {
                spiralOrder.add(matrix[hrDown][k]);
            }
            hrDown--;

            for (int l = hrDown; l >= hrUp; l--) {
                spiralOrder.add(matrix[l][vrLeft]);
            }
            vrLeft++;
            System.out.println(spiralOrder);
        }

        return spiralOrder.stream().mapToInt(i -> i).toArray();
    }

}
