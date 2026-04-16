class Solution {
    public int parseDigits(String s, int idx, int res, int sign) {
        if (idx >= s.length() || s.charAt(idx) < '0' || s.charAt(idx) > '9')
            return res * sign;

        int digit = s.charAt(idx) - '0';

        if (res > (Integer.MAX_VALUE - digit) / 10)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        return parseDigits(s, idx + 1, res * 10 + digit, sign);
    }
    public int myAtoi(String s) {
        // code here
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) == ' ')
            idx++;
        int sign = 1;
        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            if (s.charAt(idx) == '-')
                sign = -1;
            idx++;
        }

        return parseDigits(s, idx, 0, sign);
    }
}