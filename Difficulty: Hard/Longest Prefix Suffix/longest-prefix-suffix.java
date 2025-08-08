class Solution {
    int getLPSLength(String s) {
        // code here
         int base1 = 31, base2 = 37;
        int mod1 = 1000000007, mod2 = 1000000009;
        int p1 = 1, p2 = 1;
        int n = s.length();
        int[] hash1 = new int[]{0, 0};
        int[] hash2 = new int[]{0, 0};
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            hash1[0] = (int)((hash1[0] + 
                    1L * (s.charAt(i) - 'a' + 1) * p1 % mod1) % mod1);
            hash1[1] = (int)((hash1[1] + 
                    1L * (s.charAt(i) - 'a' + 1) * p2 % mod2) % mod2);
            hash2[0] = (int)((1L * hash2[0] * base1 % mod1 + 
                    (s.charAt(n - i - 1) - 'a' + 1)) % mod1);
            hash2[1] = (int)((1L * hash2[1] * base2 % mod2 + 
                    (s.charAt(n - i - 1) - 'a' + 1)) % mod2);
            if (hash1[0] == hash2[0] && hash1[1] == hash2[1]) {
                ans = i + 1;
            }
            p1 = (int)(1L * p1 * base1 % mod1);
            p2 = (int)(1L * p2 * base2 % mod2);
        }

        return ans;
    }
}