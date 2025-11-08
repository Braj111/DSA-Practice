class Solution {
    public int numberOfPath(int[][] mat, int k) {
        // code here
         int n = mat.length, m = mat[0].length;
        int[][] prev = new int[m][k + 1];
        int[][] curr = new int[m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int sum = 0; sum <= k; sum++) {
                    if (i == 0 && j == 0) {
                        curr[j][sum] = (sum == mat[0][0]) ? 1 : 0;
                        continue;
                    }

                    curr[j][sum] = 0;

                    if (sum - mat[i][j] >= 0) {
                        if (i > 0)
                            curr[j][sum] += prev[j][sum - mat[i][j]];
                        if (j > 0)
                            curr[j][sum] += curr[j - 1][sum - mat[i][j]];
                    }
                }
            }
            for (int j = 0; j < m; j++)
                prev[j] = Arrays.copyOf(curr[j], curr[j].length);
        }
        return prev[m - 1][k];
    }
}