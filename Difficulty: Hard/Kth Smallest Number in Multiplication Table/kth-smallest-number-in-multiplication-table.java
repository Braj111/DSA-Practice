class Solution {
    static int count(int val, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= m; ++i) {
            cnt += Math.min(val / i, n);
        }
        return cnt;
    }

    static int kthSmallest(int m, int n, int k) {
        int l = 1, h = m * n;
        while (l < h) {
            int mid = (l + h) / 2;
            if (count(mid, m, n) < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l; 
    }

}