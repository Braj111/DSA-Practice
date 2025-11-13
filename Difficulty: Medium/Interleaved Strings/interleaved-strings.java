class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // code here
        if (s1.length() + s2.length() != s3.length()) return false;
        int n = s1.length(), m = s2.length();
        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];
        prev[0] = true;
        for (int j = 1; j <= m; j++)
            prev[j] = prev[j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        for (int i = 1; i <= n; i++) {
            curr[0] = prev[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));

            for (int j = 1; j <= m; j++) {
                int k = i + j;
                curr[j] = (prev[j] && s1.charAt(i - 1) == s3.charAt(k - 1)) ||
                          (curr[j - 1] && s2.charAt(j - 1) == s3.charAt(k - 1));
            }
            prev = curr.clone();
        }

        return prev[m];
    }
}