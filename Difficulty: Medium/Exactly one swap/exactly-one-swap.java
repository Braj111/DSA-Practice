class Solution {
    int countStrings(String s) {
        // code here
        int n = s.length();
        int[] map = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (i - map[s.charAt(i) - 'a']);
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 1) {
                ans++; 
                break;
            }
        }

        return ans;
    }
}