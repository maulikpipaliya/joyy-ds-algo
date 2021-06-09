public void BubbleSortImproved(int[] A) {
    int pass, i, temp, swapped = 1;
    for (pass = A.length - 1; pass >= 0 && swapped; pass--) {
      swapped = 0;
      for (i = 0; i <= pass - 1; i++) {
        if (A[i] > A[i + 1]) {
          // swap elements
          temp = A[i];
          A[i] = A[i + 1];
          A[i + 1] = temp;
          swapped = 1;
        }
      }
    }
  }