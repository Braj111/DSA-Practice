import java.util.*;

class SegmentTree {
    private long[] tree;
    private int[] arr;
    private int n;

    public SegmentTree(int[] input) {
        arr = input.clone();
        n = arr.length;
        tree = new long[4 * n];
        build(1, 0, n - 1);
    }

    long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node, start, mid, idx, val);
        else
            update(2 * node + 1, mid + 1, end, idx, val);

        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    long query(int node, int start, int end, int l, int r) {
        if (end < l || start > r)
            return 1;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        long left = query(2 * node, start, mid, l, r);
        long right = query(2 * node + 1, mid + 1, end, l, r);

        return lcm(left, right);
    }

    public void update(int idx, int val) {
        update(1, 0, n - 1, idx, val);
    }

    public long query(int l, int r) {
        return query(1, 0, n - 1, l, r);
    }
}

class Solution {

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {

        SegmentTree st = new SegmentTree(arr);

        ArrayList<Long> result = new ArrayList<>();

        for (int[] q : queries) {

            int type = q[0];

            if (type == 1) {

                int idx = q[1];
                int val = q[2];

                st.update(idx, val);

            } else {

                int l = q[1];
                int r = q[2];

                result.add(st.query(l, r));
            }
        }

        return result;
    }
}