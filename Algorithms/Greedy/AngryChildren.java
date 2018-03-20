import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AngryChildren {

    static int angryChildren(int k, int[] arr) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int diff;
        
        for (int i = 0; i <= n - k; i++) {
            diff = arr[i + (k - 1)] - arr[i];
            if (diff < minDiff) minDiff = diff;
        }
        
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = angryChildren(k, arr);
        System.out.println(result);
        in.close();
    }
}

