import java.util.*;

class Solution {

    ArrayList<Integer> dijkstra(int src, int n, ArrayList<ArrayList<int[]>> adj) {
        int INF = (int) 1e9;
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n; i++) dist.add(INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        dist.set(src, 0);
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];

            for (int[] x : adj.get(u)) {
                int v = x[0], straight = x[1];
                if (dist.get(v) > d + straight) {
                    dist.set(v, d + straight);
                    pq.offer(new int[]{dist.get(v), v});
                }
            }
        }
        return dist;
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], straight = e[2], curved = e[3];
            adj.get(u).add(new int[]{v, straight, curved});
            adj.get(v).add(new int[]{u, straight, curved});
        }

        ArrayList<Integer> da = dijkstra(a, V, adj);
        ArrayList<Integer> db = dijkstra(b, V, adj);

        int ans = da.get(b);

        for (int u = 0; u < V; u++) {
            for (int[] x : adj.get(u)) {
                int v = x[0], curved = x[2];
                ans = Math.min(ans, da.get(u) + curved + db.get(v));
                ans = Math.min(ans, da.get(v) + curved + db.get(u));
            }
        }

        if (ans >= 1000000000) ans = -1;
        return ans;
    }
}
