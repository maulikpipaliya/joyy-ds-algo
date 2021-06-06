public interface ISortable {
     <T extends Comparable<? super T>> void sort(List<T> list);
}
