class Solution {
    int cntOnes(int[][] grid) {
        // code here
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        int[] queue = new int[n * m * 2];
        int head = 0;
        int tail = 0;
        int[] rowDir = { 1, 0, -1, 0 };
        int[] colDir = { 0, 1, 0, -1 };
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                grid[i][0] = 0;
                queue[tail++] = i;
                queue[tail++] = 0;
            }
            if (grid[i][m - 1] == 1) {
                grid[i][m - 1] = 0;
                queue[tail++] = i;
                queue[tail++] = m - 1;
            }
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                grid[0][j] = 0;
                queue[tail++] = 0;
                queue[tail++] = j;
            }
            if (grid[n - 1][j] == 1) {
                grid[n - 1][j] = 0;
                queue[tail++] = n - 1;
                queue[tail++] = j;
            }
        }
        while (head < tail) {
            int r = queue[head++];
            int c = queue[head++];
            for (int k = 0; k < 4; k++) {
                int nr = r + rowDir[k];
                int nc = c + colDir[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m
                    && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0; 
                    queue[tail++] = nr; 
                    queue[tail++] = nc;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += grid[i][j];
            }
        }

        return count;
    }
};