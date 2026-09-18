/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static void inorder(Node curr, Node[] prev, int[] ans)
        {
            if (curr == null)
                return;
            inorder(curr.left, prev, ans);
            if (prev[0] != null)
                ans[0] = Math.min(ans[0],curr.data - prev[0].data);

            prev[0] = curr;
            inorder(curr.right, prev, ans);
        }
        static int absDiff(Node root)
        {
            Node[] prev = new Node[1];
            int[] ans = new int[] { Integer.MAX_VALUE };
            inorder(root, prev, ans);

            return ans[0];
        }
}
