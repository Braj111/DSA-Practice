//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        int n = str.length();
        boolean[] visited = new boolean[26];
        int distinct = 0;

        for (int i = 0; i < n; i++) {
            if (visited[str.charAt(i) - 'a'] == false) {
                visited[str.charAt(i) - 'a'] = true;
                distinct++;
            }
        }
        int[] cur = new int[26];
        int cnt = 0;

        int ans = n;
        int start = 0;
        for (int i = 0; i < n; i++) {
            cur[str.charAt(i) - 'a']++;

            if (cur[str.charAt(i) - 'a'] == 1) {
                cnt++;
            }
            while (cnt == distinct) {
                ans = Math.min(ans, i - start + 1);
                cur[str.charAt(start) - 'a']--;
                if (cur[str.charAt(start) - 'a'] == 0) {
                    cnt--;
                }
                start++;
            }
        }
        return ans;
    }
}