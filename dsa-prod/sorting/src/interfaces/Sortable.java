/**
 * Sortable <? super T> = ? is a super class of T <? extends T> = ? is a sub
 * class of T
 * 
 * mode
 */

package interfaces;

public interface Sortable {
    <T extends Comparable<? super T>> void sort(T[] values, boolean isAscending);
}