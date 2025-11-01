class Solution {
     public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> stack) {
        
        visited[node] = 1; 

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) {
                return false; 
            } else if (visited[neighbor] == 0) {
                if (!dfs(neighbor, adj, visited, stack)) {
                    return false; 
                }
            }
        }
        visited[node] = 2; 
        stack.add(node);
        return true;
    }
    
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            adj.get(src).add(dest);
        }

        int[] visited = new int[n];
        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, adj, visited, stack)) {
                    return new ArrayList<>(); 
                }
            }
        }
        Collections.reverse(stack); 
        return stack;
    }
}