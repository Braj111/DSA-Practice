class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        // code here
        int n = mat.length, m = mat[0].length;
        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i + 1][j + 1]
                    = prefix[i][j + 1] + prefix[i + 1][j]
                      - prefix[i][j] + mat[i][j];
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int i = q[0], j = q[1];
            int minDist
                = Math.min(Math.min(i, j),
                           Math.min(n - i - 1, m - j - 1));
            if (mat[i][j] > k) {
                res.add(-1);
                continue;
            }
            int lo = 0, hi = minDist, best = 0;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int r1 = i - mid;
                int c1 = j - mid;
                int r2 = i + mid;
                int c2 = j + mid;
                int sum = prefix[r2 + 1][c2 + 1]
                          - prefix[r1][c2 + 1]
                          - prefix[r2 + 1][c1]
                          + prefix[r1][c1];
                if (sum <= k) {
                    best = mid;
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            res.add(2 * best + 1);
        }

        return res;
    }
}