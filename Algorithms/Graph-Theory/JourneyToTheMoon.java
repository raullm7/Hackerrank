import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Graph {
    LinkedList<Long>[] adj;
    long V;
    private boolean[] visited;
    private long result = 0;
    
    public Graph(long V) {
        this.V = V;
        adj = new LinkedList[(int)V];
        visited = new boolean[(int)V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Long>();
    }
    
    public void addEdge(long v, long w) {
        adj[(int)v].add(w);
    }
    
    public long DFS() {
        result = 0;
        long size = 0;
        long sum = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                size = dfsHelper(i, 1);
                result += sum * size;
                sum += size;
            }
        }
        
        return result;
    }
    
    public long dfsHelper (int i, long size) {
        visited[i] = true;
        Iterator<Long> iter = adj[i].listIterator();
        while(iter.hasNext()) {
            long n = iter.next();
            if (!visited[(int)n]) {
                size = dfsHelper((int)n, ++size);
            }
        }
        return size;
    }
}

public class JourneyToTheMoon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long p = in.nextLong();
        Graph g = new Graph(n);
        long a, b;
        for(int i = 0; i < p; i++){
            a = in.nextLong();
            b = in.nextLong();
            g.addEdge(a, b);
            g.addEdge(b, a);
        }
        long result = g.DFS();
        System.out.println(result);
        in.close();
    }
}

