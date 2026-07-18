class Solution {
    static int mod = (int) 1e9 + 7;

    static int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] suf = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--)
                suf[i][j] = suf[i + 1][j] + suf[i][j + 1] - suf[i + 1][j + 1] + matrix[i][j];
        int[][][] dp = new int[n][m][k + 1];
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                dp[r][c][1] = suf[r][c] > 0 ? 1 : 0;

        for (int p = 2; p <= k; p++) {
            int[][] sufRow = new int[n + 1][m];
            for (int c = 0; c < m; c++)
                for (int r = n - 1; r >= 0; r--)
                    sufRow[r][c] = (sufRow[r + 1][c] + dp[r][c][p - 1]) % mod;
            int[][] sufCol = new int[n][m + 1];
            for (int r = 0; r < n; r++)
                for (int c = m - 1; c >= 0; c--)
                    sufCol[r][c] = (sufCol[r][c + 1] + dp[r][c][p - 1]) % mod;

            for (int r = n - 1; r >= 0; r--) {
                for (int c = m - 1; c >= 0; c--) {
                    if (suf[r][c] == 0) continue;
                    int res = 0;
                    int lo = r + 1, hi = n;
                    while (lo < hi) {
                        int mid = (lo + hi) / 2;
                        if (suf[mid][c] < suf[r][c]) hi = mid;
                        else lo = mid + 1;
                    }
                    if (lo < n)
                        res = (res + sufRow[lo][c]) % mod;
                    int lo2 = c + 1, hi2 = m;
                    while (lo2 < hi2) {
                        int mid = (lo2 + hi2) / 2;
                        if (suf[r][mid] < suf[r][c]) hi2 = mid;
                        else lo2 = mid + 1;
                    }
                    if (lo2 < m)
                        res = (res + sufCol[r][lo2]) % mod;

                    dp[r][c][p] = res;
                }
            }
        }
        return dp[0][0][k];
    }

}