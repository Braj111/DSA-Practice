class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer((long) num);
        }
        int operationsCount = 0;
        while (priorityQueue.size() > 1 && priorityQueue.peek() < k) {
            operationsCount++;
            long first = priorityQueue.poll();
            long second = priorityQueue.poll();
            priorityQueue.offer(Math.min(first, second) * 2 + Math.max(first, second));
        }
        return priorityQueue.peek() >= k ? operationsCount : -1;
    }
}
