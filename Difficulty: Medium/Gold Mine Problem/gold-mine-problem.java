class Solution {
    static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static int maxGold(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        for (int y = m - 2; y >= 0; y--) {
            for (int x = 0; x < n; x++) {
                int maxprev = 0;
                if (isValid(x - 1, y + 1, n, m)) {
                    maxprev = Math.max(maxprev, mat[x - 1][y + 1]);
                }
                if (isValid(x, y + 1, n, m)) {
                    maxprev = Math.max(maxprev, mat[x][y + 1]);
                }
                if (isValid(x + 1, y + 1, n, m)) {
                    maxprev = Math.max(maxprev, mat[x + 1][y + 1]);
                }
                mat[x][y] += maxprev;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, mat[i][0]);
        }

        return result;
    }
}