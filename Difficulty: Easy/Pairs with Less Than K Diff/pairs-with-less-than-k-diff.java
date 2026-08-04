class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);

        int total = 0;
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] - arr[s] >= k) {
                s++;
            }
            total += (i - s);
        }

        return total;
    }
}
