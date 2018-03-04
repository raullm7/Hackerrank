import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSort1 {

    static void insertionSort1(int n, int[] arr) {
        int u = arr[n - 1];
        boolean inserted = false;
        for (int i = n - 2; i >=0; i--) {
            if (arr[i] > u) {
                arr[i + 1] = arr[i];
                printArray(arr);
            } else {
                arr[i + 1] = u;
                printArray(arr);
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            arr[0] = u;
            printArray(arr);
        }
    }
    
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}

