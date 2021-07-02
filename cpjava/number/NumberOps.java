import java.util.*;
import java.math.BigInteger;

public class NumberOps {
    public static void main(String[] args) {
        System.out.println("Hello");

        System.out.println(getFactorial(5));
    }

    public static BigInteger getFactorialBigInt(int n) {
        // BigInteger start = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static String getFactorial(int n) {

        LinkedList<Integer> result = new LinkedList<Integer>();

        result.add(1);

        System.out.println("result: " + result);

        
        for (int i = 2; i <= 5; i++) {
            
        }

        return "";
    }

  

}
