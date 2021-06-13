import org.graalvm.compiler.core.common.type.ArithmeticOpTable.UnaryOp.Abs;

public interface Sorter{
	void sort(Comparable[] array);
}

public abstract class AbstractSorter implements Sorter{
	protected Comparable[] array;
    protected int n;
    
    protected abstract void sort();

    public final void sort(Comparable[] array) {
        n = array.length;
        this.array = array;
        if (n > 0)
            sort();
        this.array = null;
    }

    protected final void swap(int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

public class InsertionSorter extends AbstractSorter {
    protected void sort() {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && array[j-1].compareTo(array[j]) > 0; j--) {
                swap(j, j - 1);
            }
        }
    }
}