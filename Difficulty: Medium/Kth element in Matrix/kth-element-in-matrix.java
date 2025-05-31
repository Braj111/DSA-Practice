class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int curr = matrix[i][j];
                pq.offer(curr);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}