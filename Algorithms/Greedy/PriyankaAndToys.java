import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PriyankaAndToys {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
      
        Arrays.sort(a);
        int cost = 1;
        int p = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > p + 4) {
                cost++;
                p = a[i];
            }
        }
        System.out.println(cost);
    }
}
