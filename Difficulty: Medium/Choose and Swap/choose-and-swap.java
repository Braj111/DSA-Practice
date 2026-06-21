class Solution {
    public String chooseSwap(String s) {
        // code here
        int n = s.length();
        int[] first = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }
        }

        char x = 0, y = 0;
        int pos = -1;
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';

            for (int c = 0; c < cur; c++) {
                if (first[c] > i) {
                    pos = i;
                    x = s.charAt(i);
                    y = (char)('a' + c);
                    break;
                }
            }

            if (pos != -1) {
                break;
            }
        }
        if (pos == -1) {
            return s;
        }

        char[] res = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (res[i] == x) {
                res[i] = y;
            }
            else if (res[i] == y) {
                res[i] = x;
            }
        }

        return new String(res);
    }
}