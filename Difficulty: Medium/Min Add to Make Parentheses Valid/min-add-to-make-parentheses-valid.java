class Solution {
    public int minParentheses(String s) {
        int n = s.length();
        int unmatchedClosing = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                balance++;
            }
            else if (s.charAt(i) == ')') {
                balance--;
                if (balance < 0) {
                    unmatchedClosing++;
                    balance = 0;
                }
            }
        }
        int unmatchedOpening = 0;
        balance = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                balance++;
            }
            else if (s.charAt(i) == '(') {
                balance--;
                if (balance < 0) {
                    unmatchedOpening++;
                    balance = 0;
                }
            }
        }
        return unmatchedClosing + unmatchedOpening;
    }
}
