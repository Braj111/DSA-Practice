class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        int n = arr.length;
        int low = 0, high = n - 1, pos = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                pos = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int left = pos, right = pos + 1;
        if (right < n && arr[right] == x) right++;
        
        int[] res = new int[k];
        int count = 0;
        while (left >= 0 && right < n && count < k) {
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);
            
            if (leftDiff < rightDiff) {
                res[count++] = arr[left];
                left--;
            }
            else {
                res[count++] = arr[right];
                right++;
            }
        }
        while (left >= 0 && count < k) {
            res[count++] = arr[left];
            left--;
        }
        
        while (right < n && count < k) {
            res[count++] = arr[right];
            right++;
        }
        
        return res;
    }
}
