class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        int n = arr.length;
                if (n == 1) {
                    return 1;
                }
                HashMap<Integer, Integer> dp = new HashMap<>();
                int ans = 1;
                for (int i = 0; i < n; ++i) {
                    if (dp.containsKey(arr[i] + 1) || dp.containsKey(arr[i] - 1)) {

                        dp.put(arr[i], 1 +
                               Math.max(dp.getOrDefault(arr[i] + 1, 0),
                                       dp.getOrDefault(arr[i] - 1, 0)));
                    } 
                    else {
                        dp.put(arr[i], 1);  
                    }
                    ans = Math.max(ans, dp.get(arr[i]));
                }

                return ans;
    }
}
