class Solution {
    static int findInterval(int[] prefix, int low, int high,
                            int rank)
    {
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (prefix[mid] < rank)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
    static ArrayList<Integer>
    getMarks(int[] l, int[] r, int[] rank)
    {
        int n = l.length;
        int[] prefix = new int[n];

        prefix[0] = r[0] - l[0] + 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (r[i] - l[i] + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            int idx
                = findInterval(prefix, 0, n - 1, rank[i]);
            int diff = prefix[idx] - rank[i];
            ans.add(r[idx] - diff);
        }

        return ans;
    }
}