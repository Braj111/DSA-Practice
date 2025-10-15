/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int kthSmallest(Node root, int k) {
        // code here
        int count = 0;
        
        
        Node curr = root;
        int nodes = 0;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if( count == k ) return curr.data;
                curr = curr.right;
            } 
            else {
                
                Node prev = curr.left;
                while (prev.right != null && 
                       prev.right != curr) {
                    prev = prev.right;
                }
                
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } 
                else {
                    count++;
                    if( count == k ) return curr.data;
                
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}