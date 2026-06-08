class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] ans= new int[n];
        int index=0;
        for(int i:nums){
            if(i<pivot) ans[index++]=i;
        }
        for(int i:nums){
            if(i==pivot) ans[index++]=i;
        }
        for(int i:nums){
            if(i>pivot) ans[index++]=i;
        }
        return ans;
    }
}