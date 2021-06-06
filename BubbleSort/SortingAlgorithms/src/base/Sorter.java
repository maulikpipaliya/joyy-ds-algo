package base;

/**
 * @author Luciano Sampaio
 */
public abstract class Sorter {

	/**
	 * Swap the elements of the array based on the first and the second position.
	 * 
	 * @param values
	 *            the array that will have its values swapped.
	 * @param first
	 * @param second
	 */
	protected <T> void swap(T[] values, int first, int second) {
		T temp = values[first];

		values[first] = values[second];
		values[second] = temp;
	}

}
