import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BonAppetit {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();
        
        int charged = sc.nextInt();
        
        int actual = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) actual += prices[i];
        }
        actual /= 2;
        
        if (actual == charged) System.out.println("Bon Appetit");
        else System.out.println(charged - actual);
    }
}

