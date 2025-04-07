//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static List<Integer>[] constructadj(int V, int[][] edges)
    {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]); 
        }
        return adj;
    }
    static boolean isCyclic(int V, int[][] edges)
    {
        List<Integer>[] adj
            = constructadj(V, edges); 

        int[] inDegree= new int[V]; 
        Queue<Integer> q= new LinkedList<>(); 
        int visited= 0; 
        for (int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                inDegree[v]++;
            }
        }
        for (int u = 0; u < V; u++) {
            if (inDegree[u] == 0) {
                q.offer(u);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;
            for (int v : adj[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return visited != V;
    }
}