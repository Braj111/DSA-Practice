class Solution {

    private int solve(int[] arr, int l, int r, int lr, int rl) {
        if (l > r) return 0;

        int m = l + (r - l) / 2;
        int ans = 0;

        if (lr < arr[m] && arr[m] < rl) {
            ans = 1;
        }

        int left =
            solve(arr, l, m - 1, lr, Math.min(rl, arr[m]));

        int right =
            solve(arr, m + 1, r, Math.max(lr, arr[m]), rl);

        return ans + left + right;
    }

    public int binarySearchable(int[] arr) {
        return solve(arr, 0, arr.length - 1,
                     Integer.MIN_VALUE,
                     Integer.MAX_VALUE);
    }
}