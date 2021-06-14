package abstracts;

public abstract class AbstractSorter {
    protected <T> void swap(T[] values, int first, int second) {
        // x = x ^ y ^ (y = x);
        // a[x] = a[x] ^ a[y] ^ (a[y] = a[x]);
        T temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }

    protected <T> boolean isSorted(T[] values, boolean isAscending) {

        int n = values.length;
        boolean isSorted;

        for (int i = 0; i < n - 1; i++) {
            isSorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (isAscending && values[j].compareTo(values[j + 1]) > 0)
                    return false;
                if (!isAscending && values[j].compareTo(values[j + 1]) < 0)
                    return false;
            }
            if (isSorted)
                return true;

        }
    }
}
