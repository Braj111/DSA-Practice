class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Code here
         int E = edges.length;
        int totalPossible = V * (V - 1) / 2;
        return totalPossible - E;
    }
}