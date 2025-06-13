class Solution {
     static boolean check(int[] arr, int mid, int k) {
        int hours = 0;
        for (int i = 0; i < arr.length; i++) {
            hours += arr[i] / mid;
            if (arr[i] % mid != 0) {
                hours++;
            }
        }
        return hours <= k;
    }
    static int kokoEat(int[] arr, int k) {
        int lo = 1;
        int hi = Arrays.stream(arr).max().getAsInt();
        int res = hi;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(arr, mid, k) == true) {
                hi = mid - 1;
                res = mid;
            }
            else {
                lo = mid + 1;
            }
        }
      
        return res;
    }
}
