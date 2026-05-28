class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public int length = Integer.MAX_VALUE;
    public int index = -1;
}

class Solution {

    private TrieNode root = new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] ans = new int[wordsQuery.length];
        int minIndex = 0;
        for (int i = 0; i < wordsContainer.length; ++i) {

            insert(wordsContainer[i], i);
            if (wordsContainer[i].length() < wordsContainer[minIndex].length())
                minIndex = i;
        }

        for (int i = 0; i < wordsQuery.length; ++i) {
            int index = search(wordsQuery[i]);
            ans[i] = (index == -1) ? minIndex : index;
        }

        return ans;
    }

    private void insert(String word, int wordIndex) {

        TrieNode node = root;
        if (node.length > word.length()) {
            node.length = word.length();
            node.index = wordIndex;
        }

        for (int i = word.length() - 1; i >= 0; --i) {

            int ch = word.charAt(i) - 'a';

            if (node.children[ch] == null)
                node.children[ch] = new TrieNode();
            node = node.children[ch];
            if (node.length > word.length()) {
                node.length = word.length();
                node.index = wordIndex;
            }
        }
    }

    private int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; --i) {
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null)
                return node.index;
            node = node.children[ch];
        }
        return node.index;
    }
}