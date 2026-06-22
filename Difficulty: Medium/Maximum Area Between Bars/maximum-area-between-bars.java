class Solution {
    public int maxArea(List<Integer> height) {

        int n = height.size();

        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pairs.add(new int[]{height.get(i), i});
        }

        pairs.sort((a, b) -> Integer.compare(a[0], b[0]));

        int ans = 0;

        int minIdx = pairs.get(n - 1)[1];
        int maxIdx = pairs.get(n - 1)[1];

        for (int i = n - 2; i >= 0; i--) {

            int h = pairs.get(i)[0];
            int idx = pairs.get(i)[1];

            ans = Math.max(
                ans,
                h * Math.max(0, Math.abs(idx - minIdx) - 1)
            );

            ans = Math.max(
                ans,
                h * Math.max(0, Math.abs(idx - maxIdx) - 1)
            );

            minIdx = Math.min(minIdx, idx);
            maxIdx = Math.max(maxIdx, idx);
        }

        return ans;
    }
}