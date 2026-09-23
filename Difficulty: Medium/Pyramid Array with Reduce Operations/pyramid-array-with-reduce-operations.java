class Solution {
    public int formPyramid(int[] arr) {
        // code here
        int n = arr.length;
        int totalHeight = 0;
        for (int i = 0; i < n; i++)
            totalHeight += arr[i];
        if (n <= 2)
            return totalHeight - 1;

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++)
            left[i] = Math.min(left[i - 1] + 1, arr[i]);
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.min(right[i + 1] + 1, arr[i]);

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int peakHeight = Math.min(left[i], right[i]);
            int pyramidSum = peakHeight * peakHeight;
            minCost = Math.min(minCost,
                               totalHeight - pyramidSum);
        }
        return minCost;
    }
};