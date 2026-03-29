class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum = Arrays.stream(arr).sum();
        if ((sum + diff) % 2 != 0 || sum < diff)
            return 0;

        int target = (sum + diff) / 2;
        int n = arr.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= arr[i]; j--) {
                dp[j] += dp[j - arr[i]];
            }
        }

        return dp[target];
    }
}
