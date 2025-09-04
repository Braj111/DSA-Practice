/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node newHead = null;
        Node tail = null;

        while (curr != null) {
            Node groupHead = curr;
            Node prev = null;
            Node nextNode = null;
            int count = 0;
            while (curr != null && count < k) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }
            if (newHead == null) {
                newHead = prev;
            }
            if (tail != null) {
                tail.next = prev;
            }
            tail = groupHead;
        }

        return newHead;
    }
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

}