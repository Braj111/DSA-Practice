/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
     static void sumOfRootToLeaf(Node root, int sum,int length, int[] maxLen,int[] maxSum) {
        if (root == null) {
            if (length > maxLen[0]) {
                maxLen[0] = length;
                maxSum[0] = sum;
            }
            else if (length == maxLen[0]
                     && sum > maxSum[0]) {
                maxSum[0] = sum;
            }
            return;
        }
        sumOfRootToLeaf(root.left, sum + root.data,
                        length + 1, maxLen, maxSum);
        sumOfRootToLeaf(root.right, sum + root.data,
                        length + 1, maxLen, maxSum);
    }
    static int sumOfLongRootToLeafPath(Node root) {
        if (root == null)
            return 0;
        int[] maxSum = { Integer.MIN_VALUE };
        int[] maxLen = { 0 };
        sumOfRootToLeaf(root, 0, 0, maxLen, maxSum);
        return maxSum[0];
    }
}