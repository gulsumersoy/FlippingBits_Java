import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long[] decimalToBinary(long n) {
        
        long[] binaryArr = new long[32];
        int i = 31;
        while (n > 0) {
            binaryArr[i] = n % 2;
            n = n/2;
            i--;
        }
        return binaryArr;
        
    }
    
    public static long binaryToDecimal(long[] n) {
        long decimal = 0;
        int arrIdx = n.length - 1;
        for (int i = 0; i < n.length; i++) {
            decimal += n[arrIdx-i] * Math.pow(2,i);   
        }
       
        return decimal;
    }
    
    public static long flippingBits(long n) {
    // Write your code here
        long[] binaryArr =  decimalToBinary(n);
        // flip bits
        for (int i = 0; i < binaryArr.length; i++) {
            binaryArr[i] = binaryArr[i] ^ 1;
        }
        
        return binaryToDecimal(binaryArr);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
