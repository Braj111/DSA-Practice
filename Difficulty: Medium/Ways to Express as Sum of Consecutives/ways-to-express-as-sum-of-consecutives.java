class Solution {
    public int getCount(int n) {
        // code here
        int count = 0;
        for (long k = 2; ; k++)
        {
            long baseSum = (k * (k - 1)) / 2;
            if (baseSum >= n) {
                break; 
            }
            if ((n - baseSum) % k == 0) {
                count++;
            }
        }

        return count;
    }
};