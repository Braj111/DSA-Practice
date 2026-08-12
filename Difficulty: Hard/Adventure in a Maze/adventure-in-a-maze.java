class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        // Code here
        int MOD = 1000000007;
        int n = grid.length;
        int[] nextWays = new int[n];
        int[] nextAdv = new int[n];
        Arrays.fill(nextAdv,
                    -1);
        for (int i = n - 1; i >= 0; i--) {
            int[] currWays = new int[n];
            int[] currAdv = new int[n];
            Arrays.fill(currAdv, -1);

            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) {
                    currWays[j] = 1;
                    currAdv[j] = grid[i][j];
                    continue;
                }

                long totalWays = 0;
                int maxAdventure = -1;
                int cellValue = grid[i][j];
                if (cellValue == 1 || cellValue == 3) {
                    if (j + 1 < n && currAdv[j + 1] != -1) {
                        totalWays
                            = (totalWays + currWays[j + 1])
                              % MOD;
                        maxAdventure = Math.max(
                            maxAdventure,
                            grid[i][j] + currAdv[j + 1]);
                    }
                }
                if (cellValue == 2 || cellValue == 3) {
                    if (i + 1 < n && nextAdv[j] != -1) {
                        totalWays
                            = (totalWays + nextWays[j])
                              % MOD;
                        maxAdventure = Math.max(
                            maxAdventure,
                            grid[i][j] + nextAdv[j]);
                    }
                }

                currWays[j] = (int)totalWays;
                currAdv[j]
                    = maxAdventure;
            }
            nextWays = currWays;
            nextAdv = currAdv;
        }
        int finalPaths = nextWays[0];
        int finalAdv = (nextAdv[0] == -1) ? 0 : nextAdv[0];

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(finalPaths);
        ans.add(finalAdv);
        return ans;
    }
}