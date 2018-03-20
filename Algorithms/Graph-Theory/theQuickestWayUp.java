import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    int index;
    int level;
}

public class theQuickestWayUp {

    static int quickestWayUp(int M, int[] moves) {
        boolean visited[] = new boolean[M];
        Queue<Node> q = new LinkedList<>();
        
        Node node = new Node();
        node.index = 0;
        node.level = 0;
        
        visited[0] = true;
        q.add(node);
        
        while (!q.isEmpty()) {
            node = q.remove();
            int nodeIndex = node.index;
            
            if (nodeIndex == M - 1) break;
            
            for (int i = nodeIndex + 1; i <= (nodeIndex + 6) && i < M; ++i) {
                if (!visited[i]) {
                    Node newNode = new Node();
                    newNode.level = node.level + 1;
                    visited[i] = true;
                    
                    if (moves[i] != -1)
                        newNode.index = moves[i];
                    else
                        newNode.index = i;
                    q.add(newNode);
                }
            } 
        }
        return node.index == (M - 1) ? node.level : -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){

            int M = 100;
            int moves[] = new int[M];
            for (int i = 0; i < M; i++) moves[i] = -1;
            
            int n = in.nextInt();
            for(int ladders_i = 0; ladders_i < n; ladders_i++){
                int fromLader = in.nextInt() - 1;
                int toLader = in.nextInt() - 1;
                moves[fromLader] = toLader;
            }
            int m = in.nextInt();
            for(int snakes_i = 0; snakes_i < m; snakes_i++){
                int fromSnake = in.nextInt() - 1;
                int toSnake = in.nextInt() - 1;
                moves[fromSnake] = toSnake;
            }
            
            int result = quickestWayUp(M, moves);
            System.out.println(result);
        }
        in.close();
    }
}

