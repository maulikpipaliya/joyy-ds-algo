package algorithms;

import base.Sorter;
import contract.Sortable;

/**
 * @author Luciano Sampaio
 */
public class BubbleSort extends Sorter implements Sortable {

	@Override
	public <T extends Comparable<T>> void sortAscending(T[] values) {
		sort01(values, 0, 1);
	}

	@Override
	public <T extends Comparable<T>> void sortDescending(T[] values) {
		sort01(values, 1, 0);
	}

	private <T extends Comparable<T>> void sort01(T[] values, int first, int second) {
		int length = values.length;
		int count = 0;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				count++;
				if (values[j + first].compareTo(values[j + second]) > 0) {
					swap(values, j + first, j + second);
				}
			}
		}

		System.out.print(count + ": ");
	}

	private <T extends Comparable<T>> void sort02(T[] values, int first, int second) {
		int length = values.length;
		int count = 0;
		boolean isOrdered;

		for (int i = 1; i < length; i++) {
			isOrdered = true;

			for (int j = 0; j < length - i; j++) {
				count++;
				if (values[j + first].compareTo(values[j + second]) > 0) {
					isOrdered = false;
					swap(values, j + first, j + second);
				}
			}

			if (isOrdered) {
				break;
			}
		}

		System.out.printf("%2s: ", count);
	}

}
