/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int countPathsUtil(Node node, int k, int currSum, 
                              	HashMap<Integer, Integer> prefSums) {
        if (node == null)
            return 0;

        int pathCount = 0;
        currSum += node.data;

        if (currSum == k)
            pathCount++;
        pathCount += prefSums.getOrDefault(currSum - k, 0);
        prefSums.put(currSum, prefSums.getOrDefault(currSum, 0) + 1);

        pathCount += countPathsUtil(node.left, k, currSum, prefSums);
        pathCount += countPathsUtil(node.right, k, currSum, prefSums);
        prefSums.put(currSum, prefSums.get(currSum) - 1);

        return pathCount;
    }

    public int countAllPaths(Node root, int k) {
        HashMap<Integer, Integer> prefSums = new HashMap<>();
      
        return countPathsUtil(root, k, 0, prefSums);
    }

}