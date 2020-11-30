import java.util.Random;

class BubbleSortArray {
    private long[] array;
    private int nElems;
    private int arrayCapacity;

    public BubbleSortArray(int maxSize) {
        this.arrayCapacity = maxSize;
        array = new long[this.arrayCapacity];
    }

    public void insert(long datum) {
        array[nElems++] = datum;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }     
    }

    public void doBubbleSort() {
        System.out.println();
        // long x=4,y=7;
        boolean sorted;
        for (int i = 0; i < nElems; i++) {
            System.out.print("Iteration " + (i + 1) + " : ");
            display();
            sorted = true;
            for (int j = 0; j < nElems - i - 1; j++) {
                System.out.print("\n\tSub iteration " + (j + 1) + " : ");
                // System.out.println();
                if (array[j] > array[j + 1]) {
                    System.out.print("(" + array[j] + "," + array[j + 1] + ") ==> ");
                    swap(array,j,j+1);
                    System.out.print("(" + array[j] + "," + array[j + 1] + ")\t");
                    System.out.print("Array: ");
                    display();
                    sorted = false;
                }
                else{
                    System.out.print("No swap\t");
                }
                
            }
            if (sorted) {
                System.out.println("\n\nArray is sorted");
                display();
                break;
            }
            else{
                System.out.println();
                System.out.println("\n\t" +  array[nElems-i-1] + " is bubbled up (set at correct sorting index)");
            }
            System.out.println();
        }

    }

    //Java - Pass by value only
    public void swap(long[] a, int x, int y) {
        // x = x ^ y ^ (y = x);
        //a[x] = a[x] ^ a[y] ^ (a[y] = a[x]);
        long temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}

public class BubbleSortApp {
    public static void main(String[] args) {
        // final int maxSize = 5;
        
        // long[] a = { 8,3,8,6,9,9,6,6,8,5 };
        // long[] a = { 2,7,4,1,5,3 };
        long[] a = { 6, 4, 9, 3, 5, 8 };
        int arrayLen = a.length;
        BubbleSortArray bSortArray = new BubbleSortArray(a.length);
        for (int i = 0; i < arrayLen; i++) {
            // bSortArray.insert(new Random().nextInt(10));
            bSortArray.insert(a[i]);
        }

        bSortArray.display();
        bSortArray.doBubbleSort();
        // bSortArray.display();
    }
}
