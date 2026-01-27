class Solution {
    static class Pair {
        int node;
        long cost;
        Pair(long cost, int node) {
            this.cost = cost;
            this.node = node;
        }
    }

    public int minCost(int n, int[][] edges) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w * 2});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        dist[0] = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            long cost = cur.cost;
            int u = cur.node;

            if (cost != dist[u]) continue;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                long w = edge[1];
                if (dist[v] > cost + w) {
                    dist[v] = cost + w;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
