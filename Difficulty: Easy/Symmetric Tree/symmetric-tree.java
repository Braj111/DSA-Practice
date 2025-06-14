/*
class Node{
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
    public boolean isSymmetric(Node root) {
         if (root == null) {
            return true;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
          
            Node node1 = q.poll();
            Node node2 = q.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || 
                node1.data != node2.data) {
                return false;
            }
            q.offer(node1.left);
            q.offer(node2.right);
            q.offer(node1.right);
            q.offer(node2.left);
        }
        return true;
    }
}