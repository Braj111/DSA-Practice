class Solution {
    public int validGroups(String s) {
        // code here
        int n = s.length();
        int maxSum = n * 9;
        int[][] dp = new int[n + 1][maxSum + 1];
        for (int prevSum = 0; prevSum <= maxSum;
             prevSum++) {
            dp[n][prevSum] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int prevSum = 0; prevSum <= maxSum;
                 prevSum++) {

                int currSum = 0;
                for (int j = i; j < n; j++) {

                    currSum += s.charAt(j) - '0';
                    if (currSum >= prevSum) {
                        dp[i][prevSum]
                            += dp[j + 1][currSum];
                    }
                }
            }
        }
        return dp[0][0];
    }
}