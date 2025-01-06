class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] res = new int[n];

        //forward pass
        for(int i=1, count=0; i<n; i++){
            if(boxes.charAt(i-1)=='1') count++;
            res[i]+=res[i-1]+count; //accumulating in res[]
        }
         //baackward pass
        for(int i=n-2, count=0, sum=0; i>=0; i--){
            if(boxes.charAt(i+1)=='1') count++; //accumulating in sum variable
            sum+=count; //sum act as i-1 value
            res[i]+=sum;
        }
        return res;
    }
}