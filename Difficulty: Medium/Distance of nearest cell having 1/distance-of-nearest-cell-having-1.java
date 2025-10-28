class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] front = q.poll();
                int x = front[0];
                int y = front[1];
                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for (int j = 0; j < directions.length; j++) {
                    int dx = directions[j][0];
                    int dy = directions[j][1];
                    if (x + dx >= 0 && x + dx < n && y + dy >= 0 && y + dy < m
                        && ans[x + dx][y + dy] == Integer.MAX_VALUE) {
                        ans[x + dx][y + dy] = ans[x][y] + 1;
                        q.add(new int[]{x + dx, y + dy});
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(ans[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
