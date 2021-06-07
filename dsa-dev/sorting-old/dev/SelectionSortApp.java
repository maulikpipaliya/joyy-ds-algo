import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class SelectionSortArray {
    private long[] array;
    private int nElems;
    private int arrayCapacity;
    

    public SelectionSortArray(int maxSize) {
        this.arrayCapacity = maxSize;
        array = new long[this.arrayCapacity];
    }

    public void insert(long datum) {
        array[nElems++] = datum;
    }

    public void display() {
        System.out.print(Arrays.toString(this.array));
    }

    //Variant 1
    public void selectionSort1() {
        System.out.println();


        for (int i = 0; i < array.length; i++) {
            System.out.print("\nIteration " + (i + 1) + " : ");
            display();
            for (int j = i; j < array.length - 1; j++) {
                System.out.print("\n\tSub iteration " + (j + 1) + " : ");

                if(array[i] > array[j]){
                    System.out.print("(" + array[i] + "," + array[j] + ") ==> ");
                    swap(array,i,j);
                    System.out.print("(" + array[i] + "," + array[j] + ") ==> ");
                    display();
                }
            }
    
            System.out.println();
        }
    }

    // Variant 2
    public void selectionSort2() {
        System.out.println();

        int smallestIndex;
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print("\nIteration " + (i + 1) + " : ");
            display();
            smallestIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                System.out.print("\n\tSub iteration " + j + " : ");

                if(array[j] < array[smallestIndex]){
                    smallestIndex = j;    
                }
            }
            
            System.out.println("\n\n\tSmallest is now:" + array[smallestIndex]  + "@" + smallestIndex);
            swap(array, i, smallestIndex);
            System.out.println();
        }
    }

    public void swap(long[] a, int x, int y) {
        long temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

 
}

public class SelectionSortApp {
    public static void main(String[] args) {
        // int arrayLen = 8;
        
        long[] a = {-4, 10, 5, 17, 0, -9, 25, 12};
        int arrayLen = a.length;
        
        SelectionSortArray array = new SelectionSortArray(arrayLen);

        for (int i = 0; i < arrayLen; i++) {
            // array.insert(new Random().nextInt(20));
            array.insert(a[i]);
        }

        
        array.display();
        array.selectionSort2();
        array.display();
    }
}
