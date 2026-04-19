class Solution {
    public boolean isPower(int x, int y) {
        // code here
        if (x == 1)
            return y == 1;
        if (y == 1)
            return true;
        double res = Math.log(y) / Math.log(x);
        return Math.abs(res - Math.round(res)) < 1e-10;
    }
}