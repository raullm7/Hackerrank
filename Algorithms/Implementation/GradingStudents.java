import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GradingStudents {

    static int[] solve(int[] grades){
        // Complete this function
        int[] solution = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 38) {
                solution[i] = grades[i];
            } else {
                int possibleSolution = (int) (Math.round(grades[i] / 5.0) * 5.0);
                solution[i] = Math.max(possibleSolution, grades[i]);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        

    }
}
