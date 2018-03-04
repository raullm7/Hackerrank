import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSort2 {

    static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                printArr(arr);
                continue;
            }
            int u = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > u) {
                    arr[j + 1] = arr[j];
                    arr[j] = u;
                }
            }
            printArr(arr);
        }
    }
    
    static void printArr(int[] arr) {
        for (int a : arr) System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort2(n, arr);
        in.close();
    }
}

