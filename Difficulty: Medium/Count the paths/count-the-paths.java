import java.util.*;

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        int[] memo = new int[V];
        Arrays.fill(memo, -1);

        return dfs(graph, src, dest, memo);
    }

    private int dfs(ArrayList<ArrayList<Integer>> graph, int node, int dest, int[] memo) {
        if (node == dest) return 1;
        if (memo[node] != -1) return memo[node];

        int count = 0;
        for (int neighbor : graph.get(node)) {
            count += dfs(graph, neighbor, dest, memo);
        }

        memo[node] = count;
        return count;
    }
}
