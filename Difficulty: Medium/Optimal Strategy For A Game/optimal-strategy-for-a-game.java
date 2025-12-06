
class Solution {
    public int maximumAmount(int arr[]) {
        // code here
         int n = arr.length;
        int sum = 0;
        int[] dp = new int[n];
        for (int i = (n - 1); i >= 0; i--) {
            sum += arr[i];
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[j] = arr[j];
                } else {
                    dp[j] = Math.max(arr[i] - dp[j], arr[j] - dp[j - 1]);
                }
            }
        }
        return (sum + dp[n - 1]) / 2;
    }
}
