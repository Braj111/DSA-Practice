class Solution {
    public int countSubsequences(String s, int n) {
        // code here
        int MOD = 1000000007;
        int[] dp = new int[n];
        for (char ch : s.toCharArray()) {

            int digit = ch - '0';
            int[] curr = Arrays.copyOf(dp, n);
            curr[digit % n] = (curr[digit % n] + 1) % MOD;
            for (int rem = 0; rem < n; rem++) {

                int newRem = (rem * 10 + digit) % n;
                curr[newRem]
                    = (curr[newRem] + dp[rem]) % MOD;
            }
            dp = curr;
        }

        return dp[0];
    }
}