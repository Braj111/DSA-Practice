class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int last = 0;
        int j = 0;
        int maxSum = Integer.MIN_VALUE;
        maxSum = Math.max(maxSum, sum);
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i];
            last = last + arr[j++];
            maxSum = Math.max(maxSum, sum);
            if (last < 0) {
                sum = sum - last;
                maxSum = Math.max(maxSum, sum);
                last = 0;
            }
        }

        return maxSum;
    }
}