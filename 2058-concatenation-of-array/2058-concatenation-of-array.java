class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for(int num=0; num<nums.length; num++){
            ans[num]= nums[num];
            ans[num + nums.length] = nums[num]; 
        }
        return ans;
    }
}