import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Graph {
    long v;
    LinkedList<Long>[] cities;
    boolean[] visited;
    
    public Graph (long v) {
        this.v = v;
        this.cities = new LinkedList[(int)v];
        this.visited = new boolean[(int)v];
        for (int i = 0; i < v; i++) cities[(int)i] = new LinkedList<Long>();
    }
    
    public void addEdge (long a, long b) {
        cities[(int)a].add(b);
        cities[(int)b].add(a);
    }
    
    public long dfs (int index) {
        long size = 0;
        if (!visited[index]) {
            size++;
            visited[index] = true;
            for (long next : cities[index]) {
                if (!visited[(int)next]) {
                    size += + dfs((int)next);
                }
            }
        }
        return size;
    }
}

public class RoadsAndLibraries {

    static long roadsAndLibraries(long n, long c_lib, long c_road, Graph cities) {
        if (c_lib < c_road) return n * c_lib;
        long cost = 0;
        for (int i = 0; i < n; i++) {
            long citiesSize = cities.dfs(i);
            // System.out.println("City number " + i + " of size: " + citiesSize);
            long costOfCity = 0;
            if (citiesSize == 1) costOfCity = c_lib;
            else if(citiesSize > 1) costOfCity = ((citiesSize - 1) * c_road) + c_lib;
            // System.out.println("Cost of city: " + costOfCity);
            cost += costOfCity;
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            long m = in.nextLong();
            Graph g = new Graph(n);
            long c_lib = in.nextLong();
            long c_road = in.nextLong();
            for(int cities_i = 0; cities_i < m; cities_i++){
                long a = in.nextLong() - 1;
                long b = in.nextLong() - 1;
                g.addEdge(a, b);
            }
            long result = roadsAndLibraries(n, c_lib, c_road, g);
            System.out.println(result);
        }
        in.close();
    }
}

