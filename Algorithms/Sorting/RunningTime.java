import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningTime {

    static int runningTime(int[] arr) {
        int swaps = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                continue;
            }
            int u = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > u) {
                    arr[j + 1] = arr[j];
                    swaps++;
                    arr[j] = u;
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = runningTime(arr);
        System.out.println(result);
        in.close();
    }
}


