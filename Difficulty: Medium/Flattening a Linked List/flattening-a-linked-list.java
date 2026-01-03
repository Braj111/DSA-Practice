/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/

class Solution {
    public Node flatten(Node root) {
        if (root == null || root.next == null) return root;
        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }

    public Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node temp = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
            temp.next = null;
        }
        if (a != null) temp.bottom = a;
        else temp.bottom = b;
        return dummy.bottom;
    }
}
