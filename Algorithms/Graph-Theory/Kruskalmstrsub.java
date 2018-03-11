import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long mst(int n, Node[] nodes) {
        long result = 0;
        PriorityQueue <Edge> q = new PriorityQueue<Edge>(nodes[0].edges);
        int visitedNodes = 1;
        nodes[0].visited = true;
        while (visitedNodes < n && !q.isEmpty()) {
            Edge minEdge = null;

            for (Edge e : q)
                if (!nodes[e.destination].visited) {
                    minEdge = e;
                    break;
                }

            q.remove(minEdge);
            minEdge.used = true;
            int origin = minEdge.origin;
            int destination = minEdge.destination;
            nodes[destination].visited = true;

            visitedNodes++;
            result += minEdge.distance;

            for (Edge e : nodes[destination].edges) {
                if (!e.used && !nodes[e.destination].visited) {
                    q.add(e);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for(int edges_i = 0; edges_i < m; edges_i++){
            int origin = in.nextInt() - 1;
            int dest = in.nextInt() - 1;
            int dist = in.nextInt();

            nodes[origin].addEdge(origin, dest, dist);
            nodes[dest].addEdge(dest, origin, dist);
        }

        long result = mst(n, nodes);
        System.out.println(result);
        in.close();
    }
}

class Node {
    int index;
    PriorityQueue <Edge> edges;
    boolean visited;

    Node (int index) {
        this.index = index;
        this.edges = new PriorityQueue<Edge>();
        this.visited = false;
    }

    void addEdge (int ori, int dest, int dist) {
        edges.add(new Edge(ori, dest, dist));
    }
}

class Edge implements Comparable {
    int origin;
    int destination;
    int distance;
    boolean used;

    Edge (int origin, int destination, int distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.used = false;
    }

    @Override
    public int compareTo (Object anotherEdge) throws ClassCastException {
        if (!(anotherEdge instanceof Edge))
          throw new ClassCastException("A Edge object expected.");
        Edge edge = (Edge) anotherEdge;
        if (this.distance == edge.distance) {
            return ((this.origin + this.destination) - (edge.origin + edge.destination));
        }
        return this.distance - ((Edge) anotherEdge).distance;
    }
}
