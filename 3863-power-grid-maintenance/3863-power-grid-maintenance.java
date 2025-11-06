import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] parent = new int[c + 1];
        int[] size = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Union all connections
        for (int[] e : connections) union(e[0], e[1], parent, size);

        // Map from component root → TreeSet of online nodes
        Map<Integer, TreeSet<Integer>> compMap = new HashMap<>();
        boolean[] online = new boolean[c + 1];
        for (int i = 1; i <= c; i++) {
            online[i] = true;
            int root = find(i, parent);
            compMap.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int t = q[0], x = q[1];
            int root = find(x, parent);
            TreeSet<Integer> set = compMap.get(root);

            if (t == 1) {
                if (online[x]) res.add(x);
                else {
                    if (set == null || set.isEmpty()) res.add(-1);
                    else res.add(set.first());
                }
            } else {
                if (online[x]) {
                    online[x] = false;
                    set.remove(x);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int a, int b, int[] parent, int[] size) {
        int pa = find(a, parent), pb = find(b, parent);
        if (pa == pb) return;
        if (size[pa] < size[pb]) {
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }
        parent[pb] = pa;
        size[pa] += size[pb];
    }
}
