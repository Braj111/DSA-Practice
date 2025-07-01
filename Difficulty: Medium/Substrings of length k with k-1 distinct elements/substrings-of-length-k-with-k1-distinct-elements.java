class Solution {
    public int substrCount(String s, int k) {
        // code here
        if (k > s.length()) return 0;
        int n = s.length();
        int[] cnt = new int[26]; 
        int ans = 0;
        int distinctCnt = 0;
        for (int i = 0; i < k - 1; i++) {
            int index = s.charAt(i) - 'a';
            cnt[index]++;
            if (cnt[index] == 1) distinctCnt++; 
        }
        for (int i = k - 1; i < n; i++) {
            int addIndex = s.charAt(i) - 'a';
            cnt[addIndex]++;
            if (cnt[addIndex] == 1) distinctCnt++; 
            if (distinctCnt == k - 1) ans++;
            int removeIndex = s.charAt(i - k + 1) - 'a';
            cnt[removeIndex]--;
            if (cnt[removeIndex] == 0) distinctCnt--; 
        }

        return ans;
    }
}