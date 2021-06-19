public static int[] getSpiralOrder2(int[).get(] A) {
    int nRows = A.size();
    int nCols = A.get(0).size();

    List<Integer> spiralOrder = new ArrayList<Integer>();

    if (nRows == 0)
        return spiralOrder;

    // int topLeft = 0, topRight = 0, bottomLeft = 0, bottomRight = 0;
    int hrUp = 0, vrRight = nCols - 1;
    int hrDown = nRows - 1, vrLeft = 0;

    while (hrUp <= hrDown && vrLeft <= vrRight) {

        for (int i = vrLeft; i <= vrRight; i++) {
            spiralOrder.add(A.get(hrUp).get(i));
        }
        hrUp++;

        for (int j = hrUp; j <= hrDown; j++) {
            spiralOrder.add(A.get(j).get(vrRight));
        }
        vrRight--;

        if (hrUp <= hrDown) {
            for (int k = vrRight; k >= vrLeft; k--) {
                spiralOrder.add(A.get(hrDown).get(k));
            }
            hrDown--;
        }

        if (vrLeft <= vrRight) {
            for (int l = hrDown; l >= hrUp; l--) {
                spiralOrder.add(A.get(l).get(vrLeft));
            }
            vrLeft++;
        }
        
    }

    return spiralOrder;
}