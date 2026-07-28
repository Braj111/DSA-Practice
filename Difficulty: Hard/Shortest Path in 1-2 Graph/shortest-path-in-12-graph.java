class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        int extra = V;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V + edges.length; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            if (wt == 1) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                adj.get(u).add(extra);
                adj.get(extra).add(v);
                adj.get(v).add(extra);
                adj.get(extra).add(u);
                extra++;
            }
        }
        int[] dist = new int[extra];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == dest) return dist[node];
            for (int nxt : adj.get(node)) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[node] + 1;
                    q.add(nxt);
                }
            }
        }
        return -1;
    }
}