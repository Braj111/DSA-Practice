class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=0, n=nums.length;
        if(n==1) return nums[0];

        int curr=0;
        int i;
        
        for(i=0; i<n-1; i++){
            if(nums[i]<nums[i+1]){
                curr+=nums[i];
                max=Math.max(max,curr);
            }else{
                curr+=nums[i];
                max=Math.max(max,curr);
                curr=0;
            }
        }
        if(nums[i]>nums[i-1]) curr+=nums[i];
        max=Math.max(max,curr);

        return max;
    }
}
