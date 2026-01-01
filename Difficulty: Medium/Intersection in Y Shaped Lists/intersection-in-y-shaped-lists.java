/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node node) {
        Node prev = null, curr = node;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        if (head1 == null || head2 == null) return null;
        Node revHead2 = reverse(head2);
        Node temp = head1;
        while (temp.next != null)
            temp = temp.next;
        temp.next = revHead2;
        Node slow = head1;
        Node fast = head1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head1;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}