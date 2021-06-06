package contract;

/**
 * @author Luciano Sampaio
 */
public interface Sortable {
	/**
	 * @param values
	 *            The array that will be sorted in ascending order.
	 */
	<T extends Comparable<T>> void sortAscending(T[] values);

	/**
	 * @param values
	 *            The array that will be sorted in descending order.
	 */
	<T extends Comparable<T>> void sortDescending(T[] values);
}
