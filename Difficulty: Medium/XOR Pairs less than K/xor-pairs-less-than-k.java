class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int cnt;
    }

    void insertTrie(TrieNode root, int n) {
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (root.child[bit] == null) root.child[bit] = new TrieNode();
            root.child[bit].cnt++;
            root = root.child[bit];
        }
    }

    int cntSmaller(TrieNode root, int n, int k) {
        int ans = 0;
        for (int i = 31; i >= 0 && root != null; i--) {
            int x = (n >> i) & 1;
            int y = (k >> i) & 1;
            if (y == 1) {
                if (root.child[x] != null) ans += root.child[x].cnt;
                root = root.child[1 - x];
            } else {
                root = root.child[x];
            }
        }
        return ans;
    }

    public int cntPairs(int[] arr, int k) {
        TrieNode root = new TrieNode();
        int res = 0;
        for (int x : arr) {
            res += cntSmaller(root, x, k);
            insertTrie(root, x);
        }
        return res;
    }
}
