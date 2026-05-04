class Solution {
    public boolean isBinaryPalindrome(int x) {
        // code here
        int rev = 0, temp = x;
        while (temp > 0) {
            rev = (rev << 1) | (temp & 1);
            temp >>= 1; 
        }

        return x == rev;
    }
};