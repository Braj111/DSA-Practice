class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            pre[i]=pre[i-1]+arr[i];
        }
        int even=0;
        int odd=0;
        int res=0;
        for(int i=0; i<n; i++){
            if(pre[i]%2==0){
                res=(res+odd)%1000000007;
                even++;
            }
            else{
                res=(res+even +1)%1000000007;
                odd++;
            }
        }
        return res;
    }
}