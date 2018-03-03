import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BreakingBestAndWorstRecords {

    static int[] breakingRecords(int[] score) {
        int[] results = new int[2];
        int min, max;
        min = max = score[0];
        
        for (int s : score) {
            if (s > max) {
                results[0]++;
                max = s;
            } else if (s < min) {
                results[1]++;
                min = s;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}

