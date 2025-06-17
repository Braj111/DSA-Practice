class Solution {
    public int minimumCoins(int[] arr, int k) {
        // code here
        Arrays.sort(arr); 
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + arr[i];

        int ans = Integer.MAX_VALUE, prev = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            if (i > 0) {
                prev = prefix[i - 1];
            }

            int pos = upperBound(arr, arr[i] + k, i, n);

            int totalToRemove = prev;
            if (pos < n) {
                totalToRemove += prefix[n - 1] - prefix[pos - 1] - (n - pos) * (arr[i] + k);
            }

            ans = Math.min(ans, totalToRemove);
        }

        return ans;
    }

    private int upperBound(int[] arr, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
