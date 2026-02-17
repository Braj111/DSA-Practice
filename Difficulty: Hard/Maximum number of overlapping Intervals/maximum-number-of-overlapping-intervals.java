
class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int[] interval : arr) {
            mp.put(interval[0], mp.getOrDefault(interval[0], 0) + 1);
            mp.put(interval[1] + 1, mp.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int ans = 0, count = 0;
        for (int change : mp.values()) {
            count += change;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
