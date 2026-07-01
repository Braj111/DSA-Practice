class Solution {
    public int maxSumSubarray(int[] arr) {
        // code here
        int n = arr.length;
        int noDel = arr[0];
        int oneDel = 0;
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            oneDel = Math.max(noDel, arr[i] + oneDel);
            noDel = Math.max(arr[i], arr[i] + noDel);
            ans = Math.max(ans, Math.max(noDel, oneDel));
        }

        return ans;
    }
}