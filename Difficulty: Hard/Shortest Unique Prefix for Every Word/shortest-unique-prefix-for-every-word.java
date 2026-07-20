import java.util.*;

class TrieNode {
    TrieNode[] child;
    int freq;

    TrieNode() {
        child = new TrieNode[26];
        freq = 0;
    }
}

class Solution {

    static void insert(TrieNode root, String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
            curr.freq++;
        }
    }

    static String getPrefix(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            curr = curr.child[ch - 'a'];
            sb.append(ch);

            if (curr.freq == 1) {
                break;
            }
        }

        return sb.toString();
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();

        for (String word : arr) {
            insert(root, word);
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String word : arr) {
            ans.add(getPrefix(root, word));
        }

        return ans;
    }
}