class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1, dec=1, max=1, n=nums.length;

        for(int i=0; i<n-1; i++){
            if(nums[i]>nums[i+1]){
                inc++; dec=1;max=Math.max(max,inc);
            }else if(nums[i]<nums[i+1]){
                dec++; inc=1;max=Math.max(max,dec);
            }else{
                inc=1; dec=1;
            }
        }
        return max;
    }
}