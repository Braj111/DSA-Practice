/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int lh= height(root.left, 1);
        int rh= height(root.right, 1);  
        return (Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right));
    }
    public int height(TreeNode root, int height){
        if(root==null) return 0;
        int lh=0, rh=0;
        if(root.left!=null){
            lh=height(root.left,height);
        }
        if(root.right!=null){
            rh=height(root.right,height);
        }
        return Math.max(lh,rh)+1;
    }

}