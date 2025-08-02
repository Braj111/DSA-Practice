class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) sum--;
            else sum++;
            if (sum > 0) ans = i + 1;
            else {
                if (mp.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - mp.get(sum - 1));
                }
            }
            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }

        return ans;
    }
}