class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int N = 1 << n;
        int[][] dp = new int[N][n];
        for (int i = 0; i < N; i++) 
            java.util.Arrays.fill(dp[i], -1);
        return solve(1, 0, cost, dp);
    }

    private int solve(int mask, int pos, int[][] cost, int[][] dp) {
        int n = cost.length;
        if (mask == (1 << n) - 1) return cost[pos][0];
        if (dp[mask][pos] != -1) return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int val = cost[pos][city] + solve(mask | (1 << city), city, cost, dp);
                ans = Math.min(ans, val);
            }
        }
        return dp[mask][pos] = ans;
    }
}
