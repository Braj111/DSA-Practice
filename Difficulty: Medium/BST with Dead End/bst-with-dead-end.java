/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
     static boolean dfs(Node root, int mini, int maxi) {
        if (root == null) return false;
        if (root.left == null && root.right == null &&
        mini == maxi) {
            return true;
        }
        return dfs(root.left, mini, root.data-1) || 
        dfs(root.right, root.data+1, maxi);
    }
    static boolean isDeadEnd(Node root) {
        return dfs(root, 1, Integer.MAX_VALUE);
    }
}