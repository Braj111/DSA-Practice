class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        int maxSum = 0;
        Arrays.sort(arr);

        int n = arr.length;
        for (int i = n - 1; i > 0; --i) 
        {
            if (arr[i] - arr[i - 1] < k)
            {
                maxSum += arr[i];
                maxSum += arr[i - 1];
                --i;
            }
        }

        return maxSum;
    }
}