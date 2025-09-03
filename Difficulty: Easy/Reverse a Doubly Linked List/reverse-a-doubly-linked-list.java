/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node currNode = head;
        Node prevNode = null;
        while (currNode != null) {
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;
            currNode = currNode.prev;
        }
        head = prevNode.prev;
        return head;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            if(node.next != null){
                System.out.print(" <-> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}