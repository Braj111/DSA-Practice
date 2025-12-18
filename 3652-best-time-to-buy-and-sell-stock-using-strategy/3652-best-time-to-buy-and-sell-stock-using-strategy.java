class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        long[] preA = new long[n + 1];
        long[] preB = new long[n + 1];

        for (int i = 0; i < n; i++) {
            preA[i + 1] = preA[i] + (long) strategy[i] * prices[i];
            preB[i + 1] = preB[i] + (long) (1 - strategy[i]) * prices[i];
        }

        long bestDelta = 0;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            long firstHalfLoss = preA[l + half] - preA[l];
            long secondHalfGain = preB[l + k] - preB[l + half];

            long delta = -firstHalfLoss + secondHalfGain;
            bestDelta = Math.max(bestDelta, delta);
        }

        return baseProfit + bestDelta;
    }
}
