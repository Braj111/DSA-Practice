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
    Stack<TreeNode> nodes= new Stack<>();
    int currDepth=0;
    int currNum=0;
    public TreeNode recoverFromPreorder(String traversal) {
        for(int i=0; i<traversal.length(); i++){
            //here handled the case1
            if(traversal.charAt(i)=='-'){
                currDepth++;
            }else{
                currNum=10*currNum+traversal.charAt(i)-'0';
            }

            //check if its the end ..string or num
            if(traversal.length()==i+1 || (Character.isDigit(traversal.charAt(i)) && traversal.charAt(i+1)=='-') ){
                TreeNode newNode =  new TreeNode(currNum);
                while(nodes.size()>currDepth) nodes.pop();
                
                if(!nodes.isEmpty()){
                    if(nodes.peek().left ==null) nodes.peek().left=newNode;
                    else nodes.peek().right=newNode;
                }
                nodes.push(newNode);
                currDepth=0;
                currNum=0;
            }

        }
        TreeNode ans=null;
        while(!nodes.isEmpty()){
            ans=nodes.pop();
        }
        return ans;
    }
    
}