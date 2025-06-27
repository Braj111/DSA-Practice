class Solution {
    public int getCount(int n) {
        // code here
        int ans = 0;

        int[][] prev = new int[4][3];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(prev[i], 1);
        }
        prev[3][0] = 0;
        prev[3][2] = 0;

        int[][] curr = new int[4][3];
        int[][] dir = {{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    curr[i][j] = 0;
                    if (i == 3 && (j == 0 || j == 2)) {
                        continue;
                    }
                    for (int[] d : dir) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < 4 && y >= 0 && y < 3) {
                            curr[i][j] += prev[x][y];
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    prev[i][j] = curr[i][j];
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                ans += prev[i][j];
            }
        }

        return ans;
    }
}