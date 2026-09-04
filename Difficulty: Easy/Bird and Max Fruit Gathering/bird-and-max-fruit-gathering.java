class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        int res = sum;
        int left = 0;
        for (int right = m; right < n + m; right++) {
            sum -= arr.get(left);
            sum += arr.get(right % n);
            res = Math.max(res, sum);
            left++;
        }

        return res;
    }
}