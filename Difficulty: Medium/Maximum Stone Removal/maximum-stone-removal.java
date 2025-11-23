class Solution {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int maxRemove(int[][] stones) {
        int offset = 10001;

        DSU dsu = new DSU(20005);
        HashSet<Integer> used = new HashSet<>();

        for (int[] s : stones) {
            int r = s[0];
            int c = s[1] + offset;

            dsu.union(r, c);

            used.add(r);
            used.add(c);
        }
        int components = 0;
        for (int node : used) {
            if (dsu.find(node) == node) {
                components++;
            }
        }

        return stones.length - components;
    }
}
