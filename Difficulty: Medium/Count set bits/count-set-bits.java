class Solution {
    public static int countSetBits(int n) {
        // code here
        if (n == 0)
            return 0;
        int x = (int)(Math.log(n) / Math.log(2));
        int fullBits = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int remaining = n - (1 << x);
        int remainingBits = countSetBits(remaining);
        return fullBits + msbBits + remainingBits;
    }
}