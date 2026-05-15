class Solution {
    public int optimalKeys(int n) {
        // code here
        if (n <= 6)
            return n;
        int[] screen = new int[n];
        for (int i = 1; i <= 6; i++)
            screen[i - 1] = i;
        for (int i = 7; i <= n; i++) {
            screen[i - 1] = Math.max(2 * screen[i - 4],Math.max(3 * screen[i - 5], 4 * screen[i - 6]));
        }
        return screen[n - 1];
    }
}