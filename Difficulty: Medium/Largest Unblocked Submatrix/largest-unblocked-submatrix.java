class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        // code here
        int k = arr.length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            rows.add(arr[i][0]);
            cols.add(arr[i][1]);
        }
        rows.add(0);
        rows.add(n + 1);

        cols.add(0);
        cols.add(m + 1);
        Collections.sort(rows);
        Collections.sort(cols);

        int maxRowGap = 0;
        int maxColGap = 0;
        for (int i = 1; i < rows.size(); i++) {
            maxRowGap = Math.max(maxRowGap,
                                 rows.get(i)
                                     - rows.get(i - 1) - 1);
        }
        for (int i = 1; i < cols.size(); i++) {
            maxColGap = Math.max(maxColGap,
                                 cols.get(i)
                                     - cols.get(i - 1) - 1);
        }
        return maxRowGap * maxColGap;
    }
}