/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        // code here
        if (root1 == null || root2 == null)
                    return root1 == root2;
                Queue<Node> q1 = new LinkedList<>();
                Queue<Node> q2 = new LinkedList<>();

                q1.offer(root1);
                q2.offer(root2);

                while (!q1.isEmpty() && !q2.isEmpty()) {
                    int n1 = q1.size();
                    int n2 = q2.size();

                    if (n1 != n2)
                        return false;

                    HashMap<Integer, Integer> freq
                        = new HashMap<>();
                    for (int i = 0; i < n1; i++) {
                        Node node1 = q1.poll();
                        Node node2 = q2.poll();
                        freq.put(node1.data,
                                 freq.getOrDefault(node1.data, 0)
                                     + 1);
                        freq.put(node2.data,
                                 freq.getOrDefault(node2.data, 0)
                                     - 1);
                        if (node1.left != null)
                            q1.offer(node1.left);

                        if (node1.right != null)
                            q1.offer(node1.right);

                        if (node2.left != null)
                            q2.offer(node2.left);

                        if (node2.right != null)
                            q2.offer(node2.right);
                    }
                    for (Map.Entry<Integer, Integer> entry :
                         freq.entrySet()) {
                        if (entry.getValue() != 0)
                            return false;
                    }
                }
                return q1.isEmpty() && q2.isEmpty();
    }
}
