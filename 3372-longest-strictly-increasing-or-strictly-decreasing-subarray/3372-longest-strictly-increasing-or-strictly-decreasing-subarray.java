class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1; 
        for (int i = 1, curr = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                curr++;
                res = Math.max(res, curr);
            }else {
                curr = 1;
            }
        }
        for (int i = 1, curr = 1; i < nums.length; ++i) {
            if (nums[i - 1] > nums[i]) {
                curr++;
                res = Math.max(res, curr);
            }else {
                curr = 1;
            }
        }
        return res;
    }
}
