import java.util.Arrays;

class Solution {
    private int[] nums;
    private int[] memo;
    private int n;

    public int rob(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.memo = new int[n];
        Arrays.fill(memo, -1);

        return dp(0);
    }

    private int dp(int i) {
        if (i >= n) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(
            dp(i + 1),
            nums[i] + dp(i + 2)
        );

        return memo[i];
    }
}
