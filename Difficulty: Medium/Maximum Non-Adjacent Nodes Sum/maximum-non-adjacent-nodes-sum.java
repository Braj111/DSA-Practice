/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    class Pair {
        int include, exclude;
        Pair(int inc, int exc) {
            this.include = inc;
            this.exclude = exc;
        }
    }

    public int getMaxSum(Node root) {
        Pair result = helper(root);
        return Math.max(result.include, result.exclude);
    }

    private Pair helper(Node node) {
        if (node == null) return new Pair(0, 0);

        Pair left = helper(node.left);
        Pair right = helper(node.right);
        int include = node.data + left.exclude + right.exclude;
        int exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

        return new Pair(include, exclude);
    }
}
