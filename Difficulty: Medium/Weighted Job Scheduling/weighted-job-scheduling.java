class Solution {
    public int maxProfit(int[][] jobs) {
        // code here
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxProfit = 0;
        for (int[] job : jobs) {
            int start = job[0], end = job[1], profit = job[2];
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                maxProfit = Math.max(maxProfit, pq.peek()[1]);
                pq.poll();
            }
            pq.offer(new int[]{end, profit + maxProfit});
        }
        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.peek()[1]);
            pq.poll();
        }
        return maxProfit;
    }
}
