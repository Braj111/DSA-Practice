class Solution {
    public int minTime(int[] ranks, int n) {
        int low = 0;
        int high = 0;
        int maxRank = 0;
        for (int r : ranks) {
            maxRank = Math.max(maxRank, r);
        }
        high = maxRank * n * (n + 1) / 2;

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canCook(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canCook(int[] ranks, int n, int time) {
        int total = 0;

        for (int r : ranks) {
            int k = 0;
            int t = 0;
            while (t + r * (k + 1) <= time) {
                k++;
                t += r * k;
            }

            total += k;
            if (total >= n) return true;
        }
        return false;
    }
}
