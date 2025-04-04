//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static boolean bfs(int start, List<Integer>[] adj,
                       boolean[] visited)
    {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { start, -1 });
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int node = front[0];
            int parent = front[1];

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[] { neighbor, node });
                }
                else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    static List<Integer>[] constructadj(int V,int[][] edges)
    {

        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        return adj;
    }
    static boolean isCycle(int V, int[][] edges)
    {
        List<Integer>[] adj = constructadj(V, edges);
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}