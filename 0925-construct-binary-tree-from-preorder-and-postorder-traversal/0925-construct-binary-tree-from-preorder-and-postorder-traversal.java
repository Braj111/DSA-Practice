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
 //using our 1-3 approach
class Solution {
    int preIndex=0;
    int postIndex=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode curr=new TreeNode(preorder[preIndex++]);
        if(curr.val!=postorder[postIndex]){
            curr.left = constructFromPrePost(preorder,postorder);
        }
        if(curr.val!=postorder[postIndex]){
            curr.right = constructFromPrePost(preorder,postorder);
        }

        postIndex++;
        return curr;
    }
}