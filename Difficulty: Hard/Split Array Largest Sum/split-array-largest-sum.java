class Solution {
    static boolean check(int mid, int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > mid)
                return false;
            sum += arr[i];
            if (sum > mid) {
                count++;
                sum = arr[i];
            }
        }
        count++;

        return count <= k;
    }

    static int splitArray(int[] arr, int k) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int start = max;
        int end = 0;

        for (int value : arr) {
            end += value;
        }
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, arr, k)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }

};