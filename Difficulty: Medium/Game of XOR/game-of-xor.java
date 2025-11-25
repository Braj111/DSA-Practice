class Solution {
    public int subarrayXor(int[] arr) {
        int result = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 != 0 && (n - i) % 2 != 0) {
                result ^= arr[i];
            }
        }

        return result;
    }
}