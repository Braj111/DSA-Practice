class Solution {
    public boolean check(int[] nums) {
        if(nums[0]>=nums[nums.length-1]){
            int i=1;
            while(i<nums.length && nums[i]>=nums[i-1]) i++;
            if(i==nums.length) return true;
            i++;
            while(i<nums.length && nums[i]>=nums[i-1]) i++;
            if(i==nums.length) return true;
        }else{//not rotated
            int i=1;
            while(i<nums.length && nums[i]>=nums[i-1]) i++;
            if(i==nums.length) return true;
        }
        return false;
    }
}
