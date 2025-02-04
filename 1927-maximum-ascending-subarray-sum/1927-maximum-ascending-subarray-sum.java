class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0; 
        int currentSum = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(i == 0 || nums[i] > nums[i - 1]) {
                currentSum += nums[i]; 
                maxSum = Math.max(maxSum, currentSum); 
            }else {
                currentSum = nums[i]; 
            }
        }
        return maxSum;
    }
}
