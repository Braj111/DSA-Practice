class Solution {
    public int shortCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int ans = Integer.MAX_VALUE;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            int[] dist = new int[V];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(u);
            dist[u] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nei : adj.get(node)) {

                    if ((node == u && nei == v) || (node == v && nei == u))
                        continue;

                    if (dist[nei] == -1) {
                        dist[nei] = dist[node] + 1;
                        q.add(nei);
                    }
                }
            }
            if (dist[v] != -1) {
                ans = Math.min(ans, dist[v] + 1);
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
