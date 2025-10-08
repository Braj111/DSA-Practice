/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node constructTreeUtil(int[] pre, int[] post, int[] preIndex,
                                  int l, int h, int size, HashMap<Integer,Integer> postMap) {
        if (preIndex[0] >= size || l > h) return null;

        Node root = new Node(pre[preIndex[0]++]);
        if (l == h) return root;
        int i = postMap.get(pre[preIndex[0]]);

        if (i <= h) {
            root.left = constructTreeUtil(pre, post, preIndex, l, i, size, postMap);
            root.right = constructTreeUtil(pre, post, preIndex, i + 1, h - 1, size, postMap);
        }

        return root;
    }

    public Node constructTree(int[] pre, int[] post) {
        int size = pre.length;
        int[] preIndex = {0};
        HashMap<Integer,Integer> postMap = new HashMap<>();
        for (int i = 0; i < size; i++) postMap.put(post[i], i);

        return constructTreeUtil(pre, post, preIndex, 0, size - 1, size, postMap);
    }
    static int getHeight(Node root, int h) {
        if (root == null) return h - 1;
        return Math.max(getHeight(root.left, h + 1), getHeight(root.right, h + 1));
    }

    public void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int lastLevel = 0;
        int height = getHeight(root, 0);

        class Pair {
            Node node; int level;
            Pair(Node n, int l){ node = n; level = l;}
        }

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(root, 0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            Node node = top.node;
            int lvl = top.level;

            if (lvl > lastLevel) {
                System.out.println();
                lastLevel = lvl;
            }
            if (lvl > height) break;
            if (node.data != -1) System.out.print(node.data + " ");
            else System.out.print("N ");
            if (node.data == -1) continue;

            if (node.left == null) pq.add(new Pair(new Node(-1), lvl + 1));
            else pq.add(new Pair(node.left, lvl + 1));

            if (node.right == null) pq.add(new Pair(new Node(-1), lvl + 1));
            else pq.add(new Pair(node.right, lvl + 1));
        }
    }

}