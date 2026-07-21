class Solution {
    public int maxIndexDifference(String s) {
        // code here
        int n = s.length();
        int[] best = new int[26];
        java.util.Arrays.fill(best, -1);
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            int farthest = i;
            if (s.charAt(i) != 'z' && best[s.charAt(i) - 'a' + 1] != -1) {
                farthest = best[s.charAt(i) - 'a' + 1];
            }
            best[s.charAt(i) - 'a'] = Math.max(best[s.charAt(i) - 'a'], farthest);
            if (s.charAt(i) == 'a') {
                ans = Math.max(ans, farthest - i);
            }
        }
        return ans;
    }
}