/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {

    public void serialize(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");
            return;
        }

        sb.append(",").append(root.data);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public int[] buildLPS(String pat) {

        int n = pat.length();
        int[] lps = new int[n];

        int len = 0;

        for (int i = 1; i < n; ) {

            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {

                if (len != 0)
                    len = lps[len - 1];
                else
                    i++;
            }
        }

        return lps;
    }

    public boolean kmp(String text, String pat) {

        int[] lps = buildLPS(pat);

        int i = 0, j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == pat.length())
                return true;

            else if (i < text.length()
                    && text.charAt(i) != pat.charAt(j)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return false;
    }
    public boolean isSubTree(Node root1, Node root2) {

        StringBuilder t1 = new StringBuilder();
        StringBuilder t2 = new StringBuilder();

        serialize(root1, t1);
        serialize(root2, t2);

        return kmp(t1.toString(), t2.toString());
    }
}