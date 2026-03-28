class Solution {
    static int timer;
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        int[] tin = new int[V];  
        int[] low = new int[V];   
        boolean[] isArticulation = new boolean[V];
        
        timer = 0;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, tin, low, adj, isArticulation);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) result.add(i);
        }
        
        if (result.size() == 0) {
            result.add(-1);
        }
        
        return result;
    }
    
    static void dfs(int node, int parent, boolean[] visited, int[] tin, int[] low,
                    ArrayList<ArrayList<Integer>> adj, boolean[] isArticulation) {
        
        visited[node] = true;
        tin[node] = low[node] = timer++;
        int children = 0;
        
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            
            if (!visited[neighbor]) {
                dfs(neighbor, node, visited, tin, low, adj, isArticulation);
                
                low[node] = Math.min(low[node], low[neighbor]);
                if (low[neighbor] >= tin[node] && parent != -1) {
                    isArticulation[node] = true;
                }
                
                children++;
            } else {
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
        if (parent == -1 && children > 1) {
            isArticulation[node] = true;
        }
    }
}