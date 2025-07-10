class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;

    TrieNode() {
        Arrays.fill(children, null);
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    boolean allPrefixesExist(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            node = node.children[idx];
            if (node == null || !node.isEnd) {
                return false;
            }
        }
        return true;
    }
}

class Solution {

    public String longestString(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        String result = "";
        Arrays.sort(words);
        for (String word : words) {
            if (trie.allPrefixesExist(word)) {
                if (word.length() > result.length() ||
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }
}
