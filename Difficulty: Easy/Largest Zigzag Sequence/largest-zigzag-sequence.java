class Solution {
    public static int zigzagSequence(int[][] mat)
    {
        int n = mat.length;
        int[] prev = mat[0];

        for (int i = 1; i < n; i++) {
            int max1 = -1, max2 = -1, maxCol = -1;
            for (int j = 0; j < n; j++) {
                if (prev[j] > max1) {
                    max2 = max1;
                    max1 = prev[j];
                    maxCol = j;
                }
                else if (prev[j] > max2) {
                    max2 = prev[j];
                }
            }

            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                curr[j] = mat[i][j]
                          + (j == maxCol ? max2 : max1);
            }
            prev = curr;
        }
        int res = 0;
        for (int x : prev) {
            res = Math.max(res, x);
        }

        return res;
    }
}