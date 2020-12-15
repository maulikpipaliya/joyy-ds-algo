import java.math.*;

class HashTable {
    int[] HashArray;
    int tblSize;

    public HashTable(int l) {
        this.tblSize = l;
        this.HashArray = new int[tblSize];

        for (int i = 0; i < HashArray.length; i++) {
            HashArray[i] = Integer.MIN_VALUE;
        }
        this.display(); // to test initial array
    }

    public boolean isFull() {
        return (this.getSize() == tblSize) ? true : false;
    }

    public int getSize() {
        int c = 0;
        for (int i = 0; i < HashArray.length; i++)
            if (HashArray[i] != Integer.MIN_VALUE)
                c++;
        return c;
    }

    public void insertLinearProbing(int number) {
        if (isFull()) {
            System.out.println("[ERROR]: ArrayOverflow");
            return;
        }

        int index = number % tblSize;

        System.out.println(number + "%" + tblSize + "=" + index);

        while (HashArray[index] != Integer.MIN_VALUE) {
            index = (index + 1) % tblSize; // wrapping up
        }
        HashArray[index] = number;

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
        while (HashArray[h] != Integer.MIN_VALUE) {
            i++;
            h = (h1 + i * h2) % tblSize;

        }
        HashArray[h] = number;        
        
        System.out.println(number + "%" + tblSize + "=" + h);

    }

    public void display() {
        for (int i : HashArray) {
            if (i != Integer.MIN_VALUE) {
                System.out.println(i);
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
        int[] arr = { 21, 42, 31, 12, 54, 20, 28 };

        
        HashTable ht = new HashTable(HashTable.getNextPrime(arr.length));

        System.out.println("[INFO] : DOUBLE HASHING");
        for (int i : arr) {
            // ht.insertLinearProbing(i);
            ht.insertDoubleHashing(i);
        }

        System.out.println("\n\n\nDISPLAY ----");
        ht.display();
        
        System.out.println(HashTable.getPrevPrime(105));
        System.out.println(HashTable.getNextPrime(7));
    }
}
