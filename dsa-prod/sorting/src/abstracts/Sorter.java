package abstracts;

public abstract class Sorter {
    protected <T> void swap(T[] values, int first, int second) {
        // x = x ^ y ^ (y = x);
        //a[x] = a[x] ^ a[y] ^ (a[y] = a[x]);
        T temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }
}
