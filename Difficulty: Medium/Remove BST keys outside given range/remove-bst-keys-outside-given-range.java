/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        // code here
         if (root == null)
            return null;
        Node left = removekeys(root.left, l, r);
        Node right = removekeys(root.right, l, r);
        if (root.data >= l && root.data <= r) {
            root.left = left;
            root.right = right;

            return root;
        }
        else if (root.data < l) {
            return right;
        }
        else {
            return left;
        }
    }
}