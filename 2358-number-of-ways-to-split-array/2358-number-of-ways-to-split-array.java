class Solution {
    public int waysToSplitArray(int[] nums) {
        if(nums.length==1) return 0;
        long[] pre= new long[nums.length];
        for(int i=0; i<nums.length;i++){
            if(i==0) {pre[i]=nums[i]; continue;}
            pre[i]=pre[i-1]+nums[i];
        }
        int res=0;
        for(int i=nums.length-1; i>0;i--){
            if(pre[i-1]>=pre[nums.length-1]-pre[i-1]) res++;
        }
        return res;
    }   
}