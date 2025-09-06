/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int countNodes(Node node) {
        int res = 1;
        Node curr = node;
        while (curr.next != node) {
            res++;
            curr = curr.next;
        }
        return res;
    }
    public int lengthOfLoop(Node head) {
        Node slow = head, fast = head;

        while (slow != null && fast != null 
               && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return countNodes(slow);
        }
        return 0;
    }

}