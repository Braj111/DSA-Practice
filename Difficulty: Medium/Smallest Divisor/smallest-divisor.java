class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
         int low = 1;
        int high = 0;
        for (int num : arr) {
            if (num > high) {
                high = num;
            }
        }
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            for (int ele : arr) {
                sum += (ele + mid - 1) / mid;
            }

            if (sum <= k) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }
}