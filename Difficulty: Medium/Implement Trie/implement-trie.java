//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    TrieNode()
    {
        children = new TrieNode[26];
        isLeaf = false;
    }
}
// User function Template for Java
class Trie {

   TrieNode root;

    public Trie() { root = new TrieNode(); }

    // Method to insert a key into the Trie
    public void insert(String key)
    {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
    }

    // Method to search a key in the Trie
    public boolean search(String key)
    {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isLeaf;
    }

    // Method to check if a prefix exists in the Trie
    public boolean isPrefix(String prefix)
    {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }

}


//{ Driver Code Starts.

public class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            int q = sc.nextInt();
            sc.nextLine();
            List<Boolean> ans = new ArrayList<>();
            Trie ob = new Trie();

            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                String s = sc.next();
                if (i != q - 1) sc.nextLine();

                if (x == 1) {
                    ob.insert(s);
                } else if (x == 2) {
                    ans.add(ob.search(s));
                } else if (x == 3) {
                    ans.add(ob.isPrefix(s));
                }
            }

            for (Boolean result : ans) {
                System.out.print(result + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends