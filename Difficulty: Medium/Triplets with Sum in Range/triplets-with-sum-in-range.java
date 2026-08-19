class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        long ans = countAtMost(arr, r) - countAtMost(arr, l - 1);

        return (int) ans;
    }

    private long countAtMost(int[] arr, int target) {
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum <= target) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}
