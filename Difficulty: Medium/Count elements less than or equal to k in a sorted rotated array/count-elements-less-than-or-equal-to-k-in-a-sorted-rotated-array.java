class Solution {
    static int countInSorted(int[] arr, int left, int right, int x) {
        int l = left, r = right, res = left - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res - left + 1;
    }
    static int findPivot(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; 
    }
    static int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = findPivot(arr);
        int count1 = countInSorted(arr, 0, pivot - 1, x);
        int count2 = countInSorted(arr, pivot, n - 1, x);

        return count1 + count2;
    }

}
