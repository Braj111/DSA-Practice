class Solution {
    private String s;
    private long[][] memoCnt;
    private long[][] memoW;

    public long totalWaviness(long num1, long num2) {
        return count(num2) - count(num1 - 1);
    }

    private long count(long x) {
        if (x < 0) {
            return 0;
        }

        s = Long.toString(x);
        int n = s.length();
        int size = n * 11 * 11 * 2 * 2;

        memoCnt = new long[size][1];
        memoW = new long[size][1];

        for (int i = 0; i < size; i++) {
            memoCnt[i][0] = -1;
            memoW[i][0] = -1;
        }

        return dfs(0, -1, -1, true, true)[1];
    }

    private long[] dfs(int i, int prev, int prev2, boolean zero, boolean tight) {
        if (i == s.length()) {
            return new long[]{1, 0};
        }

        int key = encode(i, prev, prev2, zero, tight);

        if (memoCnt[key][0] != -1) {
            return new long[]{memoCnt[key][0], memoW[key][0]};
        }

        long cnt = 0;
        long w = 0;
        int mx = tight ? s.charAt(i) - '0' : 9;

        for (int d = 0; d <= mx; d++) {
            boolean newTight = tight && (d == s.charAt(i) - '0');
            boolean newZero = zero && (d == 0);
            int newPrev2 = prev;
            int newPrev = !newZero ? d : -1;

            long[] res = dfs(i + 1, newPrev, newPrev2, newZero, newTight);
            long newCnt = res[0];
            long nw = res[1];

            cnt += newCnt;

            if (!zero && prev2 != -1 &&
                ((prev2 < prev && prev > d) || (prev2 > prev && prev < d))) {
                w += newCnt;
            }

            w += nw;
        }

        memoCnt[key][0] = cnt;
        memoW[key][0] = w;

        return new long[]{cnt, w};
    }

    private int encode(int i, int prev, int prev2, boolean zero, boolean tight) {
        long key = i;
        key = key * 11 + (prev + 1);
        key = key * 11 + (prev2 + 1);
        key = key * 2 + (zero ? 1 : 0);
        key = key * 2 + (tight ? 1 : 0);
        return (int) key;
    }
}