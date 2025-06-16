class Solution {
    static int findCost(int[] heights, int[] cost, int h)
    {
        int res = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            res += cost[i] * Math.abs(heights[i] - h);
        }
        return res;
    }
    static int minCost(int[] heights,int[] cost)
    {
        int n = heights.length;
        int mini = Integer.MAX_VALUE, maxi
                                      = Integer.MIN_VALUE;
        for (int val : heights) {
            mini = Math.min(mini, val);
            maxi = Math.max(maxi, val);
        }

        int low = mini, high = maxi;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int val1 = findCost(heights, cost, mid - 1);
            int val2 = findCost(heights, cost, mid);
            int val3 = findCost(heights, cost, mid + 1);
            if (val2 <= val1 && val2 <= val3) {
                ans = val2;
                break;
            }
            else if (val1 >= val2 && val2 >= val3) {
                low = mid + 1;
            }
            else if (val2 >= val1 && val3 >= val2) {
                high = mid - 1;
            }
        }

        return ans;
    }
}
