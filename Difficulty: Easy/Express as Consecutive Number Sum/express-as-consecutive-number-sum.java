class Solution {
    public boolean isSumOfConsecutive(int n) {
        // code here
        if (n == 1) {
            return false;
        }
        if ((n & (n - 1)) == 0) {
            return false;
        }

        return true;
    }
}