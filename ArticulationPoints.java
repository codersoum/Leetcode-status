import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] disc, low;
    static boolean[] api;
    static int time;

    public static void  dfs(int u, int p) {
        int children = 0;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) 
        { // Ignore parent node
            
            if (disc[v] ==0) 
            { 
                children++;
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]); 
                if (low[v] >= disc[u] && p != -1)
                    api[u] = true;
            }  
            else if(v!=p)
            {
                low[u] = Math.min(low[u], disc[v]); 
            }
        }
        if(p==-1 && children>1)
         api[u] = true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt(); 
            int b = sc.nextInt(); // Number of edges

            adj = new ArrayList<>();
            for (int i = 0; i <= a; i++) 
            adj.add(new ArrayList<>()); // 1-based index
            disc = new int[a + 1];
            low = new int[a + 1];
            api = new boolean[a + 1]; // Initialize discovery times to -1
            time = 0;
            for (int i = 1; i <= b; i++) {
                int a1 = sc.nextInt();
                int b1 = sc.nextInt();
                adj.get(a1).add(b1);
                adj.get(b1).add(a1); // Undirected graph
            }

            for (int i = 1; i <= a; i++) {
                if (disc[i] == 0) {
                    dfs(i, -1); // Root articulation check
                }
            }

            int count = 0;
            for (int i = 1; i <= a; i++) {
                if (api[i]) 
               System.out.print(i+" ");

            }
            System.out.println();
        }
    }
}
