/* Structure of Binary Tree Node
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
}*/
class Solution {
    static void dfs(Node currentNode, Node parentNode, 
                    int currentLength, int[] longestPath) {
        if (currentNode == null) {
            return;
        }
    
        if (parentNode != null && 
            currentNode.data == parentNode.data + 1) {
            currentLength++;
        } else {
            currentLength = 1;
        }
    
        longestPath[0] = Math.max(longestPath[0], currentLength);
        
        dfs(currentNode.left, currentNode, currentLength, longestPath);
        dfs(currentNode.right, currentNode, currentLength, longestPath);
    }
    
    static int longestConsecutive(Node root) {
        if (root == null) {
            return -1;
        }
        
        int[] longestPath = {0};
        
        dfs(root, null, 0, longestPath);
        
        return (longestPath[0] == 1 ? -1 : longestPath[0]);
    }
}