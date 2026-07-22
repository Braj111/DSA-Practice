class Solution {
    public int minDeletions(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> tails = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int lo = 0, hi = tails.size();
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (tails.get(mid) < arr[i])
                    lo = mid + 1;
                else
                    hi = mid;
            }
            if (lo == tails.size())
                tails.add(arr[i]);
            else
                tails.set(lo, arr[i]);
        }

        return n - tails.size();
    }
}