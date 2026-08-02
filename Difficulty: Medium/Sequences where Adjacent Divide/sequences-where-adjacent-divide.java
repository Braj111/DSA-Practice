class Solution {
    static int mod = 1000000007;
    public int count(int n, int m) {
        // code here
        int[][] dp = new int[n + 1][m + 1];
        List<List<Integer> > factors = new ArrayList<>();
        List<List<Integer> > multiples = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            factors.add(new ArrayList<>());
            multiples.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {

            for (int j = i; j <= m; j += i) {

                factors.get(j).add(i);
                if (j != i) {
                    multiples.get(i).add(j);
                }
            }
        }
        for (int val = 1; val <= m; val++) {
            dp[1][val] = 1;
        }
        for (int len = 2; len <= n; len++) {

            for (int curr = 1; curr <= m; curr++) {
                for (int prev : factors.get(curr)) {

                    dp[len][curr] = (dp[len][curr] + dp[len - 1][prev]) % mod;
                }
                for (int prev : multiples.get(curr)) {

                    dp[len][curr] = (dp[len][curr] + dp[len - 1][prev]) % mod;
                }
            }
        }
        int ans = 0;

        for (int val = 1; val <= m; val++) {
            ans = (ans + dp[n][val]) % mod;
        }

        return ans;
    }
}