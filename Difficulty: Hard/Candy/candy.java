class Solution {
    public int minCandy(int arr[]) {
        // code here
        int n = arr.length;
        int total = n;
        int i = 1;
        while (i < n) {
            if (arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            int peak = 0;
            while (i < n && arr[i] > arr[i - 1]) {
                peak++;
                total += peak;
                i++;
            }

            if (i == n) {
                return total;
            }
            int valley = 0;
            while (i < n && arr[i] < arr[i - 1]) {
                valley++;
                total += valley;
                i++;
            }
            total -= Math.min(peak, valley);
        }

        return total;
    }
}
