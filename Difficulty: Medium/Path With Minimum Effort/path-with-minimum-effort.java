class Solution {
    public int minCostPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = 1_000_000;

        while (low < high) {
            int mid = (low + high) / 2;
            if (canReach(mat, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    boolean canReach(int[][] mat, int limit) {
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();
        q.add(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n-1 && cur[1] == m-1) return true;
            for (int[] d : dirs) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x>=0 && x<n && y>=0 && y<m && !vis[x][y] &&
                    Math.abs(mat[x][y] - mat[cur[0]][cur[1]]) <= limit) {
                    vis[x][y] = true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return false;
    }
}
