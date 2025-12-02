class Solution {
    public int maxScore(String s, char[][] jumps) {
        int n = s.length();
        int[][] allow = new int[128][128];
        for (char[] p : jumps) allow[p[0]][p[1]] = 1;
        for (int c = 0; c < 128; c++) allow[c][c] = 1;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) pref[i + 1] = pref[i] + s.charAt(i);

        int[][] freq = new int[n + 1][128];
        for (int i = 0; i < n; i++) {
            System.arraycopy(freq[i], 0, freq[i + 1], 0, 128);
            freq[i + 1][s.charAt(i)]++;
        }

        int[][] pos = new int[128][];
        int[] cnt = new int[128];
        for (int i = 0; i < n; i++) cnt[s.charAt(i)]++;
        for (int c = 0; c < 128; c++) pos[c] = new int[cnt[c]];
        Arrays.fill(cnt, 0);
        for (int i = 0; i < n; i++) pos[s.charAt(i)][cnt[s.charAt(i)]++] = i;

        long[] dp = new long[n];
        Arrays.fill(dp, Long.MIN_VALUE/4);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] < 0 && i != 0) continue;
            int c1 = s.charAt(i);
            for (int c2 = 0; c2 < 128; c2++) {
                if (allow[c1][c2] == 0) continue;
                int[] arr = pos[c2];
                int idx = upperBound(arr, i);
                if (idx == arr.length) continue;
                int j = arr[idx];
                long block = pref[j] - pref[i];
                long remove = (long)c2 * (freq[j][c2] - freq[i][c2]);
                long score = block - remove;
                dp[j] = Math.max(dp[j], dp[i] + score);
            }
        }

        long ans = 0;
        for (long v : dp) ans = Math.max(ans, v);
        return (int) ans;
    }

    private int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
