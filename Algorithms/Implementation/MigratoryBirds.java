import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        int[] sol = new int[n];
        int solution = 0;
        for (int a : ar) sol[a]++;
        int max = 0;
        for (int i = sol.length - 1; i >= 0; i--) {
            if (sol[i] >= max) {
                max = sol[i];
                solution = i;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}

