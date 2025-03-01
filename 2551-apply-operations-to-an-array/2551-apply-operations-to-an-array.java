class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int zero=-1; //points to non-zero
        for(int i=0; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i]=2*nums[i+1];
                nums[i+1]=0;
            }
        }
        for(int i=0,j=0; i<n && j<n;){
            if(nums[i]==0 && nums[j]!=0){
                nums[i]=nums[j];
                nums[j]=0;
            }
            while(i<n && nums[i]!=0) i++;
            j=i;
            while(j<n && nums[j]==0) j++;
        }
        return nums;
    }
}