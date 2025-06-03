// User function Template for Java

class Solution {
     static int count(String s, int k) {
        int n = s.length();
        int ans = 0;
        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1) distinctCnt++;
            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0) distinctCnt--;
                i++;
            }
            ans += j - i + 1;
        }

        return ans;
    }
    static int countSubstr(String s, int k) {
        int n = s.length();
        int ans = 0;
        ans = count(s, k) - count(s, k - 1);
        return ans;
    }
}