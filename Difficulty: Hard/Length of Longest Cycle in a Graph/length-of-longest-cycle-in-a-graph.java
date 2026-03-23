class Solution {
    public int longestCycle(int V, int[][] edges) {
    
        int[] next = new int[V];
        Arrays.fill(next, -1);

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            next[u] = v;
        }

        
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            if (next[i] != -1) {
                indegree[next[i]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;

            int nbr = next[node];
            if (nbr != -1) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        int ans = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                int curr = i;
                int count = 0;

                while (!visited[curr]) {
                    visited[curr] = true;
                    count++;
                    curr = next[curr];
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}