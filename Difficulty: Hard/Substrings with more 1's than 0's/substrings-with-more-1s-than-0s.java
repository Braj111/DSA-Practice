class Solution {
    public int countSubstring(String s) {
        // code here
        int n = s.length();
        int ans = 0;
        int zero = n;
        int minus = 0;
        int[] mp = new int[2 * n + 1];
        int cur = zero;
        for (char ch : s.toCharArray()) {
            if (ch == '0')
                cur--;
            else
                cur++;
            if (cur <= zero) {
                minus++;
            }
            mp[cur]++;
        }
        for (int i = 0; i < n; i++) {
            ans += (n - i - minus);
            if (s.charAt(i) == '1') {

                mp[zero + 1]--;

                zero++;

                minus += mp[zero];
            }
            else {

                mp[zero - 1]--;

                zero--;

                minus--;

                minus -= mp[zero + 1];
            }
        }

        return ans;
    }
}