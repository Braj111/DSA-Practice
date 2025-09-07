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
    public Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (Node head : arr) {
            if (head != null) pq.add(head);
        }
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (!pq.isEmpty()) {
            Node top = pq.poll();  
            tail.next = top;       
            tail = top;           
            if (top.next != null) {
                pq.add(top.next);  
            }
        }
        return dummy.next;
    }
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
        System.out.println();
    }
}