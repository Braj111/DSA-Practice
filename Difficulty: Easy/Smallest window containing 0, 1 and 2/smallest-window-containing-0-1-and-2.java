class Solution {
    public int smallestSubstring(String s) {
        // code here
        int n = s.length(), i = 0, j = 0, cnt = 0,
            min_len = Integer.MAX_VALUE;
        int[] freq = new int[3];

        Arrays.fill(freq, 0);
        while (j < n) {
            freq[s.charAt(j) - '0']++;
            if (freq[s.charAt(j) - '0'] == 1)
                cnt++;
            if (cnt == 3) {
                while (freq[s.charAt(i) - '0'] > 1) {
                    freq[s.charAt(i) - '0']--;
                    i++;
                }
                min_len = Math.min(min_len, j - i + 1);
                freq[s.charAt(i) - '0']--;
                i++;
                cnt--;
            }
            j++;
        }
        return (min_len == Integer.MAX_VALUE) ? -1
                                              : min_len;
    }
};
