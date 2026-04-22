class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        int q = queries.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < q; i++) {

            int l = queries[i][0];
            int r = queries[i][1];
            int sum = prefixSum[r + 1] - prefixSum[l];
            int count = r - l + 1;
            result.add(sum / count);
        }

        return result;
    }
}