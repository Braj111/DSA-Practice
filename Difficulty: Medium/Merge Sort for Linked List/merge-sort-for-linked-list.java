/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    static Node split(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
    static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            return first;
        }
        else {
            second.next = merge(first, second.next);
            return second;
        }
    }
    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node second = split(head);
        head = mergeSort(head);
        second = mergeSort(second);
        return merge(head, second);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            if(curr.next != null){
                System.out.print("-> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}