class Solution {
    int distinctSubseq(String str) {
        int n = str.length();
        int mod = 1000000007;

        long[] last = new long[26];
        long res = 1;
        char[] s = str.toCharArray();

        for (int i = 0; i < n; i++) {
            int c = s[i] - 'a';

            long cur = (2L * res % mod - last[c] + mod) % mod;
            last[c] = res;
            res = cur;
        }

        return (int) res;
    }
}
