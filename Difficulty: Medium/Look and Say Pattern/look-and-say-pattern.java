//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        // code here
        if (n == 1) return "1";

        String curr = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int cnt = 1;

            for (int j = 1; j < curr.length(); j++) {
                if (curr.charAt(j) == curr.charAt(j - 1)) {
                    cnt++;
                } else {
                    next.append(cnt).append(curr.charAt(j - 1));
                    cnt = 1;
                }
            }

            next.append(cnt).append(curr.charAt(curr.length() - 1));
            curr = next.toString();
        }

        return curr;
    }
}
