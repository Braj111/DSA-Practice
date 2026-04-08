class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int n = arr.length;
        int lo = -1, hi = n;

        while (true) {
            do {
                lo++;
            } while (lo < n && arr[lo] == 0);
            do {
                hi--;
            } while (hi >= 0 && arr[hi] == 1);
            if (lo >= hi)
                break;
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
    }   }
}
