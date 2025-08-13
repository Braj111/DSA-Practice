class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n = arr.length;
        int need = (n + 1) / 2;
        int lucky = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            if (num % k == 0) {
                ++lucky;
            } else {
                pq.add(k - (num % k));
            }
        }
        if (lucky >= need) return 0;

        int total = 0;
        int req = need - lucky;
        for (int i = 0; i < req && !pq.isEmpty(); ++i) {
            total += pq.poll();
        }

        return total;
    }
}