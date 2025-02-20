class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=0, n=nums.length; if(n==1) return 1;
        int start=0;
        boolean flag;
        
        for(int i=1; i<n;){
            //equal elements
            while(i<n && nums[i]==nums[i-1]){
                i++; 
                start++;
            }

            flag=false;

            //strictly increasing
            while(i<n && nums[i]>nums[i-1]){
                i++;
                flag=true;
            }
            System.out.println(i + " "+ start );
            max= Math.max(max,i-start);
            if(flag) {start=i-1; continue;}

            //strictly decreasing
            while(i<n && nums[i]<nums[i-1]){
                i++;
                flag=true;
            }
            max= Math.max(max,i-start);
            if(flag) {start=i-1; continue;}

        }
        return max;
    }
}