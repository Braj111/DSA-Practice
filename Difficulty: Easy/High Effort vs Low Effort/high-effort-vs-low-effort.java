class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
        int n = h.length;
        if (n == 0)
            return 0;
        int prev2 = 0;
        int prev1 = Math.max(h[0], l[0]);
        if (n == 1)
            return prev1;
        int curr = Math.max(h[1], l[1] + prev1);

        prev2 = prev1;
        prev1 = curr;
        for (int i = 2; i < n; i++) {
            curr = Math.max(l[i] + prev1, h[i] + prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}