/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public int storeSum(Node root, HashMap<Node, Integer> map) {
        if (root == null)
            return 0;

        int leftSum = storeSum(root.left, map);
        int rightSum = storeSum(root.right, map);

        int total = root.data + leftSum + rightSum;

        map.put(root, total);

        return total;
    }

    public void solve(Node root, HashMap<Node, Integer> map) {
        if (root == null)
            return;

        int leftSum = (root.left != null) ? map.get(root.left) : 0;

        int rightSum = (root.right != null) ? map.get(root.right) : 0;

        root.data = leftSum + rightSum;

        solve(root.left, map);
        solve(root.right, map);
    }

    public void toSumTree(Node root) {
        if (root == null)
            return;

        HashMap<Node, Integer> map = new HashMap<>();
        storeSum(root, map);

        solve(root, map);
    }

    public void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);

        System.out.print(root.data + " ");

        printInorder(root.right);
    }
}