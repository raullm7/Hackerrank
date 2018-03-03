import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BetweenTwoSets {

    static int getTotalX(int[] a, int[] b) {
        int solution = 0;
        
        for (int i = a[a.length - 1]; i <= b[0]; i++) {
            boolean bDivisor = true;
            for (int bb : b) {
                if (bb % i != 0) {
                    bDivisor = false;
                    break;
                }
            }
            if (bDivisor) {
                for (int aa : a) {
                    if (i % aa != 0) {
                        bDivisor = false;
                        break;
                    }
                }
            }
            if (bDivisor) solution++;
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}

