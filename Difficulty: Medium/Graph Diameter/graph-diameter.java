import java.util.*;

class Solution {
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int farthestNode = bfsFarthestNode(0, adj, V);
        int diameter = bfsMaxDistance(farthestNode, adj, V);
        
        return diameter;
    }
    private int bfsFarthestNode(int start, List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int node = start;

        while (!q.isEmpty()) {
            node = q.poll();
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return node;
    }
    private int bfsMaxDistance(int start, List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];
            maxDist = Math.max(maxDist, dist);

            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(new int[]{nei, dist + 1});
                }
            }
        }
        return maxDist;
    }
}
