class Solution {
    public long pairAndSum(int[] arr) {
        // code here
        long ans = 0;
        int n = arr.length;
        for (int i = 0; i < 32; i++) {
            long k = 0;
            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i))!= 0)
                    k++;
            ans += (1L << i) * (k * (k - 1) / 2);
        }

        return ans;
    }
}