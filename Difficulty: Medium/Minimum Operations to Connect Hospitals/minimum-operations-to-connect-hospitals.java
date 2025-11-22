class Solution {
    public int minConnect(int V, int[][] edgesArr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edgesArr) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[V];
        int edges = edgesArr.length;
        
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        if (edges < V - 1) return -1;

        int extra = edges - (V - components);
        if (extra >= components - 1) return components - 1;

        return -1;
    }

    private void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[start] = true;
        for (int neighbor : adj.get(start)) {
            if (!visited[neighbor]) dfs(neighbor, adj, visited);
        }
    }
}
