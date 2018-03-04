import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BfsShortReach {

    static int[] bfs(int n, int m, int[][] edges, int s) {
        List<LinkedList<Integer>> tree = new ArrayList<LinkedList<Integer>>(n);
        for (int i = 0; i < n; i++) tree.add(i, new LinkedList<Integer>());
        for (int[] e : edges) {
            tree.get(e[0] - 1).add(e[1] - 1);
            tree.get(e[1] - 1).add(e[0] - 1);
        }
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s - 1);
        visited[s - 1] = true;
        while (!stack.empty()) {
            int head = stack.pop();
            for (int i : tree.get(head)) {
                if (i == s - 1) continue;
                int distance = distances[head];
                if (distances[i] == 0 || distances[i] > distance + 6) {
                    distances[i] = distance + 6;
                    stack.push(i);
                }
            }
        }
        int[] solution = new int[distances.length - 1];
        for (int i = 0; i < s - 1; i++) {
            if (distances[i] == 0) solution[i] = -1;
            else solution[i] = distances[i];
        }
        for (int i = s; i < distances.length; i++) {
            if (distances[i] == 0) solution[i - 1] = -1;
            else solution[i - 1] = distances[i];
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for(int edges_i = 0; edges_i < m; edges_i++){
                for(int edges_j = 0; edges_j < 2; edges_j++){
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}

