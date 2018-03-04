import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenTree {
    
    static int evenTree(List<LinkedList<Integer>> tree) {
        int solution = 0;
        for (int i = 1; i < tree.size(); i++) {
            if ((numberChildren(tree, i) + 1) % 2 == 0) {
                solution++;
            }
        }
        return solution;
    }
    
    static int numberChildren(List<LinkedList<Integer>> tree, int index) {
        int solution = tree.get(index).size();
        for (int i : tree.get(index)) {
            solution += numberChildren(tree, i);
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<LinkedList<Integer>> tree = new ArrayList<LinkedList<Integer>>(n);
        for (int i = 0; i < n; i++) tree.add(i, new LinkedList<Integer>());
        
        for(int tree_i = 0; tree_i < m; tree_i++){
            int first = in.nextInt() - 1;
            int second = in.nextInt() - 1;
            tree.get(second).offer(first);
        }
        int result = evenTree(tree);
        System.out.println(result);
        in.close();
    }
}

