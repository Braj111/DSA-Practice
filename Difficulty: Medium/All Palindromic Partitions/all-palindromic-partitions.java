class Solution {
    public static void palindromes(String s, boolean[][] dp) {
    int n = s.length();
    for (int i = 0; i < n; ++i)
        dp[i][i] = true;
    for (int i = 0; i < n - 1; ++i)
        dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
    for (int len = 3; len <= n; ++len) {
        for (int i = 0; i <= n - len; ++i) {
            int j = i + len - 1;
            dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
        }
    }
}

public static void backtrack(int idx, String s, ArrayList<String> curr,
                             ArrayList<ArrayList<String>> res, boolean[][] dp) {
    if (idx == s.length()) {
        res.add(new ArrayList<>(curr));
        return;
    }
    for (int i = idx; i < s.length(); ++i) {
        if (dp[idx][i]) {
            curr.add(s.substring(idx, i + 1));
            backtrack(i + 1, s, curr, res, dp);
            curr.remove(curr.size() - 1);
        }
    }
}

public static ArrayList<ArrayList<String>> palinParts(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    palindromes(s, dp);
    ArrayList<ArrayList<String>> res = new ArrayList<>();
    ArrayList<String> curr = new ArrayList<>();
    backtrack(0, s, curr, res, dp);
    return res;
}

}
