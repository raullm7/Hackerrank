import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Order {
    int index;
    int time;

    Order (int i, int t) {
        index = i;
        time = t;
    }
}

public class JimAndOrders {
    static int[] jimOrders(int[][] o) {
        int n = o.length;
        int[] result = new int[n];
        ArrayList<Order> orders = new ArrayList<Order>(n);
        
        for (int i = 0; i < n; i++) {
            orders.add(new Order(i, o[i][0] + o[i][1]));
        }
        
        Collections.sort(orders, (o1, o2) ->
            o1.time > o2.time ? 1 : o1.time == o2.time ? 0 : -1);
        
        for (int i = 0; i < n; i++) {
            result[i] = orders.get(i).index + 1;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] orders = new int[n][2];
        for(int orders_i = 0; orders_i < n; orders_i++){
            for(int orders_j = 0; orders_j < 2; orders_j++){
                orders[orders_i][orders_j] = in.nextInt();
            }
        }
        int[] result = jimOrders(orders);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}

