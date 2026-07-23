class Solution {

    static void buildBSTHelper(int[] preIndex, int n,
                               List<Integer> pre,
                               int min, int max) {

        if (preIndex[0] >= n)
            return;

        int val = pre.get(preIndex[0]);

        if (val > min && val < max) {
            preIndex[0]++;

            // Left subtree
            buildBSTHelper(preIndex, n, pre, min, val);

            // Right subtree
            buildBSTHelper(preIndex, n, pre, val, max);
        }
    }

    static boolean canRepresentBST(List<Integer> arr) {
        int[] preIndex = {0};

        buildBSTHelper(preIndex, arr.size(), arr,
                       Integer.MIN_VALUE,
                       Integer.MAX_VALUE);

        return preIndex[0] == arr.size();
    }
}