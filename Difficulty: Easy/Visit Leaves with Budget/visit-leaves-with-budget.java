/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        // code here
        if (root == null)
                    return 0;

                Queue<Node> q = new LinkedList<>();
                q.add(root);

                int level = 1;
                int cnt = 0;
                while (!q.isEmpty()) {

                    int size = q.size();
                    int leafCount = 0;
                    for (int i = 0; i < size; i++) {

                        Node curr = q.remove();
                        if (curr.left == null && curr.right == null)
                            leafCount++;
                        if (curr.left != null)
                            q.add(curr.left);

                        if (curr.right != null)
                            q.add(curr.right);
                    }
                    int canVisit = k / level;

                    int take = Math.min(leafCount, canVisit);
                    cnt += take;
                    k -= take * level;
                    if (k < level)
                        break;

                    level++;
                }

                return cnt;
    }
}