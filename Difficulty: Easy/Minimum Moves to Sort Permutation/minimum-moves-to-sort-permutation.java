class Solution {
    public int minMoves(int[] arr) {
        // code here
        int n = arr.length;
        int[] count = new int[n + 1];
        Arrays.fill(count, 0);
        for (int x : arr) {
            if (count[x - 1]!= 0) {
                count[x] = count[x - 1] + 1;
            } else {
                count[x] = 1;
            }
        }

        int longest = 0;
        for (int i = 0; i <= n; ++i) {
            longest = Math.max(longest, count[i]);
        }

        return n - longest;
    }
}