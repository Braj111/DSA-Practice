/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    static int maxDiffUtil(Node t, int[] res)
     {
         if (t == null)
             return Integer.MAX_VALUE;
         if (t.left == null && t.right == null)
             return t.data;
         int val = Math.min(maxDiffUtil(t.left, res),
                            maxDiffUtil(t.right, res));
         res[0] = Math.max(res[0], t.data - val);
         return Math.min(val, t.data);
     }
     static int maxDiff(Node root)
     {

         int[] res = { Integer.MIN_VALUE };

         maxDiffUtil(root, res);

         return res[0];
     }
}