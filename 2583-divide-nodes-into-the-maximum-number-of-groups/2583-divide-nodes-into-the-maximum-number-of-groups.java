class Solution {
    private List<Integer>[] graph; 
    private List<Integer> componentNodes = new ArrayList<>(); 
    private boolean[] visited;
    private int totalNodes;
    public int magnificentSets(int n, int[][] edges) {
        totalNodes = n;
        graph = new List[n + 1];
        Arrays.setAll(graph, k -> new ArrayList<>()); 
        for (int[] edge : edges) { 
            int nodeA = edge[0], nodeB = edge[1];
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }

        visited = new boolean[n + 1];
        int totalMagnificentSets = 0;
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                dfs(i); 
                int largestDepth = -1;
                for (int node : componentNodes) {
                    largestDepth = Math.max(largestDepth, bfs(node));
                }
                if (largestDepth == -1) {
                    return -1; 
                }
                totalMagnificentSets += largestDepth; 
                componentNodes.clear(); 
            }
        }
        return totalMagnificentSets; 
    }
    private int bfs(int startNode) {
        int[] depth = new int[totalNodes + 1];
        Arrays.fill(depth, Integer.MAX_VALUE); 
        depth[startNode] = 1; // Depth of start node is 1
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode); // Initialize the queue with the starting node

        int maxDepth = 1; // Track the maximum depth
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph[currentNode]) {
                if (depth[neighbor] == Integer.MAX_VALUE) {
                    depth[neighbor] = depth[currentNode] + 1; // Update the depth of the neighbor
                    maxDepth = depth[neighbor]; // Update the max depth
                    queue.offer(neighbor); // Add the neighbor node to the queue
                }
            }
        }
        for (int node : componentNodes) {
            if (depth[node] == Integer.MAX_VALUE) {
                depth[node] = ++maxDepth;
            }
        }
        for (int node : componentNodes) {
            for (int neighbor : graph[node]) {
                if (Math.abs(depth[node] - depth[neighbor]) != 1) {
                    return -1;
                }
            }
        }

        return maxDepth; // Return the largest depth in the BFS tree
    }

    // Helper method for DFS to traverse all nodes in a connected component
    private void dfs(int currentNode) {
        componentNodes.add(currentNode); // Add current node to component list
        visited[currentNode] = true; // Mark current node as visited
        for (int neighbor : graph[currentNode]) { // Visit all unvisited neighbors
            if (!visited[neighbor]) {
                dfs(neighbor); // Recursively visit neighbors
            }
        }
    }
}
