class Solution {
    public int findSmallest(int[] arr) {
        // code here
        int res = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length && arr[i] <= res; i++) {
            res += arr[i];
        }

        return res;
    }
}