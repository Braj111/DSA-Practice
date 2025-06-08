class Solution {
       static String addStrings(String num1, String num2) {
        
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        String sum = "";
        int carry = 0;
        for (int i = 0; i < len2; i++) {
            int d1 = num1.charAt(len1 - 1 - i) - '0';
            int d2 = num2.charAt(len2 - 1 - i) - '0';
            int digit = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            sum = (char)(digit + '0') + sum;
        }
        for (int i = len2; i < len1; i++) {
            int d = num1.charAt(len1 - 1 - i) - '0';
            int digit = (d + carry) % 10;
            carry = (d + carry) / 10;
            sum = (char)(digit + '0') + sum;
        }
        if (carry > 0) {
            sum = (char)(carry + '0') + sum;
        }

        return sum;
    }
    static boolean checkSequence(String s, int start, 
                                  int len1, int len2) {
        String part1 = s.substring(start, start + len1);
        String part2 = s.substring(start + len1, start + len1 + len2);
        String expectedSum = addStrings(part1, part2);

        int sumLen = expectedSum.length();
        if (start + len1 + len2 + sumLen > s.length()) {
            return false;
        }
        if (expectedSum.equals(s.substring(start + 
                                len1 + len2, start + 
                                len1 + len2 + sumLen))) {
            if (start + len1 + len2 + sumLen == s.length()) {
                return true;
            }
            return checkSequence(s, start + len1, len2, sumLen);
        }
        return false;
    }
    static boolean isSumString(String s) {
        int n = s.length();
        for (int len1 = 1; len1 < n; len1++) {
            for (int len2 = 1; len1 + len2 < n; len2++) {
                if (checkSequence(s, 0, len1, len2)) {
                    return true;
                }
            }
        }

        return false;
    }

}