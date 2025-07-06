class Solution {
    public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        reverse(a);
        reverse(b);

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.sum, x.sum));
        Set<Long> vis = new HashSet<>();

        pq.offer(new Pair(a[0] + b[0], 0, 0));
        vis.add(hash(0, 0, n));

        ArrayList<Integer> res = new ArrayList<>();

        while (res.size() < k && !pq.isEmpty()) {
            Pair top = pq.poll();
            res.add(top.sum);
            int i = top.i, j = top.j;

            if (i + 1 < n && vis.add(hash(i + 1, j, n))) {
                pq.offer(new Pair(a[i + 1] + b[j], i + 1, j));
            }
            if (j + 1 < n && vis.add(hash(i, j + 1, n))) {
                pq.offer(new Pair(a[i] + b[j + 1], i, j + 1));
            }
        }

        return res;
    }

    static class Pair {
        int sum, i, j;
        Pair(int s, int i, int j) {
            this.sum = s;
            this.i = i;
            this.j = j;
        }
    }
    private static long hash(int i, int j, int n) {
        return (long) i * n + j;
    }

    private static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
