class Solution {
    public int palindromicStrings(int n, int k) {
        // code here
        int MOD = 1000000007;
        long[][] nPr = new long[k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    nPr[i][j] = 1;
                else
                    nPr[i][j]
                        = (nPr[i - 1][j] % MOD
                           + (j * nPr[i - 1][j - 1]) % MOD)
                          % MOD;
            }
        }
        long res = 0;
        for (int i = 1; i <= n / 2; i++)
            res = (res + nPr[k][i]) % MOD;

        res = (res * 2) % MOD;
        if ((n & 1) != 0)
            res = (res + nPr[k][n / 2 + 1]) % MOD;

        return (int)res;
    }
}