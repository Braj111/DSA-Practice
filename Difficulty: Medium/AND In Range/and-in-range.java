class Solution {
    public int andInRange(int l, int r) {
        // Code here
        int shiftCount = 0;
        while (l != r && l > 0) {
            shiftCount++;
            l = l >> 1;
            r = r >> 1;
        }
        return (l << shiftCount);
    }
}
