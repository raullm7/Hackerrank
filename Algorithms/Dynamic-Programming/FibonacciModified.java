import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciModified {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger t1 = new BigInteger(in.nextInt()+"");
        BigInteger t2 = new BigInteger(in.nextInt()+"");
        BigInteger temp = new BigInteger("0");
        int n = in.nextInt();
        for (int i = 0; i < n - 2; i++) {
            temp = t2;
            t2 = t1.add(t2.multiply(t2));
            t1 = temp;
        }
        System.out.println(t2);
        in.close();
    }
}

