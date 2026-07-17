class Solution {
    public int bitonic(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 0)
            return 0;
        int maxLen = 1;
        int start = 0;
        int nextStart = 0;
        int j = 0;
        while (j < n - 1) { 
            while (j < n - 1 && arr[j] <= arr[j+1]) 
                j++;
            while (j < n - 1 && arr[j] >= arr[j+1]) {
                if (j < n - 1 && arr[j] > arr[j+1])
                    nextStart = j + 1;
                j++;
            }
            maxLen = Math.max(maxLen, j - start+1);
            start = nextStart;
        }
        return maxLen;
    }
}