class Solution {
    public int squaredDis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // code here
         PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        for (int i = 0; i < points.length; i++) {
            int dist = squaredDis(points[i]);
            int[] entry = new int[]{dist, i};

            if (maxHeap.size() < k) {
                maxHeap.add(entry);
            } else {
                if (dist < maxHeap.peek()[0]) {
                    maxHeap.poll();
                    maxHeap.add(entry);
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int idx = maxHeap.poll()[1];
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(points[idx][0]);
            temp.add(points[idx][1]);
            res.add(temp);
        }

        return res;
    }
}