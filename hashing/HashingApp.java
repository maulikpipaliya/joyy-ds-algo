import java.math.*;

class HashTable {
    int[][] HashArray;
    int tblSize;

    public HashTable(int l) {
        this.tblSize = l;
        this.HashArray = new int[tblSize][2];

        for (int i = 0; i < HashArray.length; i++) {
            HashArray[i][0] = Integer.MIN_VALUE;
            HashArray[i][1] = 0; // 0 - unvisited 1- deleted 
        }
        this.display(); // to test initial array
    }

    public boolean isFull() {
        return (this.getSize() == tblSize) ? true : false;
    }

    public int getSize() {
        int c = 0;
        for (int i = 0; i < HashArray.length; i++)
            if (HashArray[i][0] != Integer.MIN_VALUE && HashArray[i][1] == 0)
                c++;
        return c;
    }


    //rehashing
    
    public void insertLinearProbing(int number) {
        if (isFull()) {
            System.out.println("[ERROR]: ArrayOverflow");
            return;
        }

        int index = number % tblSize;

        System.out.println(number + "%" + tblSize + "=" + index);

        while (HashArray[index][0] != Integer.MIN_VALUE && HashArray[index][1] == 0) {
            index = (index + 1) % tblSize; // wrapping up
        }
        HashArray[index][0] = number;
        HashArray[index][1] = 0;
    }

    public void insertDoubleHashing(int number) {

        if (isFull()) {
            System.out.println("[ERROR]: ArrayOverflow");
            return;
        }
        int index = number % tblSize;
        int h1 = index;
        int h2 = HashTable.getPrevPrime(tblSize) - (number % HashTable.getPrevPrime(tblSize));
        int i = 0;
        int h = (h1 + i * h2) % tblSize;

        while (HashArray[h][0] != Integer.MIN_VALUE && HashArray[h][1] == 0) {
            i++;
            h = (h1 + i * h2) % tblSize;
        }

        HashArray[h][0] = number;

        System.out.println(number + "%" + tblSize + "=" + h);

    }

    public void deleteElement(int number) {
        //here element will be deleted.
        
        //find the element
        int index = number % tblSize;
 
        while ((HashArray[index][0] != number)) {
            index = (index + 1) % tblSize;
        }

        System.out.println("----" + HashArray[index][0] + "@" + index);
        HashArray[index][0] = Integer.MIN_VALUE;
        HashArray[index][1] = 1;



        
        if (HashArray[index][1] == 1) 
            System.out.print(": ");
        else
            System.out.print("Element found: ");
        System.out.println(HashArray[index][0]);

    }

    public void display() {
        for (int i = 0; i < HashArray.length; i++) {
            if (HashArray[i][0] != Integer.MIN_VALUE && HashArray[i][1] == 0) {
                System.out.println(HashArray[i][0]);
            } else {
                System.out.println("--");
            }
        }
    }


    //ignore complexity 

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getPrevPrime(int num) {
        int count = 0;

        for (int a = num - 1; a >= 1; a--) {
            for (int b = 2; b < a; b++) {
                if (a % b == 0)
                    count++;
            }
            if (count == 0) {
                if (a == 1) {
                    break;
                }
                return a;

            }
            count = 0;
        }
        return 0;
    }

    public static int getNextPrime(int input){
        int counter;
        input++;
        while(true){
          int l = (int) Math.sqrt(input);
          counter = 0;
          for(int i = 2; i <= l; i ++){
            if(input % i == 0)  counter++;
          }
          if(counter == 0)
            return input;
          else{
            input++;
            continue;
          }
        }
      }


}

public class HashingApp {
    public static void main(String[] args) {

        // clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Hashing App");
        System.out.println("-----------");
        int[] arr = { 21, 42, 31, 19, 12, 54,30, 20, 28 };

        
        HashTable ht = new HashTable(HashTable.getNextPrime(arr.length));

        System.out.println("[INFO] : DOUBLE HASHING");
        for (int i : arr) {
            ht.insertLinearProbing(i);
            // ht.insertDoubleHashing(i);
        }

        System.out.println("\n\n\nDISPLAY ----");
        ht.display();
        
        ht.deleteElement(54);
        ht.deleteElement(30);
        ht.deleteElement(45);
        
        ht.display();
        
    }
}
