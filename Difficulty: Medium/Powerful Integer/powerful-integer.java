class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int ans = -1;
        int temp = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int delta = entry.getValue();

            if (delta >= 0) {
                temp += delta;
                if (temp >= k) {
                    ans = point;
                }
            } else {
                if (temp >= k) {
                    ans = point - 1;
                }
                temp += delta;
            }
        }

        return ans;
    }
}