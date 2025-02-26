class Solution {
    public int maxAbsoluteSum(int[] arr) {
        int n= arr.length;
        int[] pre = new int[n];
        pre[0]=arr[0];
        for(int i=1; i<n; i++){
            pre[i]=pre[i-1]+arr[i];
        }
        System.out.println(Arrays.toString(pre));
        int min=0, max=0;
        for(int i=0; i<n; i++){
            max=Math.max(max,pre[i]);
            min=Math.min(min,pre[i]);
        }
        System.out.println(max + " "+ min);
        return Math.abs(max-min);
    }
}