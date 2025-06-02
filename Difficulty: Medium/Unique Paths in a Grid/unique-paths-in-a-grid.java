class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
         int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return 0;
        }
        int[] dp = new int[m];
        dp[m-1] = 1;
        for(int j = m-2; j >= 0; j--) {
            if(grid[n-1][j] == 1) {
                dp[j] = 0;
            }
            else {
                dp[j] = dp[j+1];
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if(grid[i][m-1] == 1) {
                dp[m-1] = 0;
            }
            for(int j = m-2; j >= 0; j--) {
                if(grid[i][j] == 1) {
                    dp[j] = 0;
                }
                else {
                    dp[j] = dp[j] + dp[j+1];
                }
            }
        }
        
        return dp[0];
    }
};