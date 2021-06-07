package abstracts;

public abstract class Sorter {
    protected <T> void swap(T[] values, int first, int second) {
        T temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }
}
