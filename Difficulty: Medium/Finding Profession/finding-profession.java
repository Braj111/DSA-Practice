class Solution {
    public String profession(int level, int pos) {
        int c = countSetBits(pos - 1);
        return (c % 2 == 1) ? "Doctor" : "Engineer";
    }

    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}