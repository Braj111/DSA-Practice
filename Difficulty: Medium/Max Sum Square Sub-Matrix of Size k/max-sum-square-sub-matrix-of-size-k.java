class Solution {
    public int maximumSum(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int[] colSum = new int[n];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colSum[j] += mat[i][j];
                if (i >= k)
                    colSum[j] -= mat[i - k][j];
            }
            if (i >= k - 1) {
                int windowSum = 0;
                for (int j = 0; j < n; j++) {
                    windowSum += colSum[j];
                    if (j >= k)
                        windowSum -= colSum[j - k];
                    if (j >= k - 1)
                        res = Math.max(res, windowSum);
                }
            }
        }
        return res;
    }
}