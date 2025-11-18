class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int[] minTime = new int[V];
        int[] paths = new int[V];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;
        paths[0] = 1;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[1];
            int currentTime = top[0];

            if (currentTime > minTime[node]) continue;

            for (int[] nxt : adj.get(node)) {
                int nextNode = nxt[0];
                int edgeTime = nxt[1];
                int newTime = currentTime + edgeTime;

                if (newTime < minTime[nextNode]) {
                    minTime[nextNode] = newTime;
                    paths[nextNode] = paths[node];
                    pq.offer(new int[]{newTime, nextNode});
                } else if (newTime == minTime[nextNode]) {
                    paths[nextNode] += paths[node];
                }
            }
        }
        return paths[V - 1];
    }
}
