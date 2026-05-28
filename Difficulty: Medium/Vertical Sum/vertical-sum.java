/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        Map<Integer, Integer> mp = new TreeMap<>();
        verticalSumUtil(root, 0, mp);
        ArrayList<Integer> result = new ArrayList<>();
        for (int sum : mp.values()) {
            result.add(sum);
        }
        return result;
    }

    public void verticalSumUtil(Node node, int hd, Map<Integer, Integer> mp) {

        if (node == null)
            return;
        verticalSumUtil(node.left, hd - 1, mp);
        mp.put(hd, mp.getOrDefault(hd, 0) + node.data);
        verticalSumUtil(node.right, hd + 1, mp);
    }
}