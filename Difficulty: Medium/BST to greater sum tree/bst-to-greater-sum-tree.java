/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    public void updateTree(Node root, int[] sum) {
        if (root == null) {
            return;
        }
        updateTree(root.right, sum);
        sum[0] += root.data;
        root.data = sum[0] - root.data;
        updateTree(root.left, sum);
    }
    public void transformTree(Node root) {
        // code here
        int[] sum = {0}; 
        updateTree(root, sum);
    }
}