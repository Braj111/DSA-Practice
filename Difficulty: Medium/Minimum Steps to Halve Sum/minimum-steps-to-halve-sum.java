class Solution {
    public int minOperations(int[] arr) {
        // code here
         double sum = 0;
        for (int x : arr) sum += x;
        double target = sum / 2;
        PriorityQueue<Double> pq = 
                new PriorityQueue<Double>((a, b) -> Double.compare(b, a));
        for (int x : arr) pq.add((double)x);

        int ops = 0;
        while (sum > target) {
            double x = pq.poll();
            double h = x / 2;
            sum -= h;
            pq.add(h);
            ops++;
        }
        return ops;
    }
}