/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int bfs(Node root)
    {
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            cnt++;
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }

        return cnt;
    }
    public int getSize(Node root)
    {
        if (root == null)
            return 0;
        return bfs(root);
    }
}