class Solution {
    public int[] twoSum(int[] nums, int target) {
       int output[];
       output = new int[2];

       for(int num = 0;num<nums.length; num++){
           for(int num2 = 1; num2<nums.length; num2++){
               if(num!=num2 && nums[num]+nums[num2]==target){
                   output[0]=num;
                   output[1]=num2;
               }
           }
       }
       return output;  
    }
    //Time Complexity- O(n^2)
    //Spaace Complexity- O(1)=C
}
